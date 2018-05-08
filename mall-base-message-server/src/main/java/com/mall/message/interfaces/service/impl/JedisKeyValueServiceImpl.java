package com.mall.message.interfaces.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mall.core.domain.utils.Constants;
import com.mall.core.domain.utils.TimeUtils;
import com.mall.message.interfaces.service.KeyValueService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
//@Service
@Deprecated
public class JedisKeyValueServiceImpl implements KeyValueService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public long setNX(String key, String value, int expire) {
        long result;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.setnx(key, value);
            if (result == 1) {
                jedis.expire(key, expire);
            }
        }
        return result;
    }

    @Override
    public void put(String key, int expire, String value, int dbIndex) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(dbIndex);
            jedis.setex(key, expire, value);
        }
    }

    @Override
    public String get(String key, int dbIndex) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(dbIndex);
            return jedis.get(key);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getOrDefault(String key, T defaultValue, int expire, int dbIndex) {
        if (StringUtils.isEmpty(key))
            return null;
        T resultValue = defaultValue;
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(dbIndex);
            String queryValue = jedis.get(key);
            if (StringUtils.isEmpty(queryValue)) {
                jedis.set(key, String.valueOf(defaultValue));
                jedis.expire(key, expire);
            } else {
                if (defaultValue instanceof Integer) {
                    resultValue = (T) Integer.valueOf(queryValue);
                } else if (defaultValue instanceof Long) {
                    resultValue = (T) Long.valueOf(queryValue);
                } else {
                    resultValue = (T) queryValue;
                }
            }
        }
        return resultValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getOrDefaultSystemVariable(String key, T defaultValue, int expire, int dbIndex) {
        if (StringUtils.isEmpty(key))
            return null;
        T resultValue = defaultValue;
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(dbIndex); //all system variable save to no.3 storehouse
            String queryValue = jedis.get(key);
            if (StringUtils.isEmpty(queryValue)) {
                jedis.set(key, String.valueOf(defaultValue));
                jedis.expire(key, expire);
            } else {
                if (defaultValue instanceof Integer) {
                    resultValue = (T) Integer.valueOf(queryValue);
                } else if (defaultValue instanceof Long) {
                    resultValue = (T) Long.valueOf(queryValue);
                } else if (defaultValue instanceof BigDecimal) {
                    resultValue = (T) new BigDecimal(queryValue);
                } else if (defaultValue instanceof Boolean) {
                    resultValue = (T) Boolean.valueOf(queryValue);
                } else {
                    resultValue = (T) queryValue;
                }
            }
        }
        return resultValue;
    }

    @Override
    public void del(String key, int dbIndex) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(dbIndex);
            jedis.del(key);
        }
    }

    @Override
    public void putObj(String key, int expire, Object obj, int dbIndex) {
        try {
            this.put(key, expire, objectMapper.writeValueAsString(obj), dbIndex);
        } catch (JsonProcessingException e) {
            log.warn("redis parse object 2 json fail, error :", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T getObj(String key, Class<T> tClass, int dbIndex) {
        try {
            String jsonStr = this.get(key, dbIndex);
            if (null == jsonStr) {
                return null;
            } else {
                return objectMapper.readValue(this.get(key, dbIndex), tClass);
            }
        } catch (Exception e) {
            log.warn("", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setAdd(String key, Collection<?> objects, int expire) {

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(3);
            final String[] valueArr = objects.stream()
                    .map(value -> {

                        if (value instanceof String) {
                            return value;
                        }

                        try {
                            return objectMapper.writeValueAsString(value);
                        } catch (JsonProcessingException e) {
                            return null;
                        }
                    }).toArray(String[]::new);

            if (!ArrayUtils.isEmpty(valueArr)) {

                Pipeline pipeline = jedis.pipelined();
                pipeline.del(key);
                pipeline.sadd(key, valueArr);
                pipeline.expire(key, expire);

                pipeline.sync();
            }
        }
    }

    public <T> List<T> getList(String key, Class<T> tClass) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(3);
        String s = jedis.get(key);

        try {
            Map[] list = objectMapper.readValue(s, Map[].class);
            return Arrays.stream(list).parallel().map(i -> {
                try {
                    return objectMapper.readValue(objectMapper.writeValueAsBytes(i), tClass);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Set<?> setMembers(String key, Class<?> tClass) {
        Set<Object> resultSet = Sets.newHashSet();

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(3);
            final Set<String> members = jedis.smembers(key);

            if (String.class == tClass) {
                return members;
            }

            if (!CollectionUtils.isEmpty(members)) {
                resultSet.addAll(members.stream()
                        .map(member -> {
                            try {
                                return objectMapper.readValue(member, tClass);
                            } catch (IOException e) {
                                return null;
                            }
                        }).collect(Collectors.toSet()));
            }
        }

        return resultSet;
    }

    @Override
    public boolean exists(String key, int dbIndex) {
        boolean exists;
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(dbIndex);
            exists = jedis.exists(key);
        }
        return exists;
    }

    @Override
    public Map<String, Boolean> checkExists(List<String> checkKeys, int dbIndex) {

        if (CollectionUtils.isEmpty(checkKeys)) {
            return Collections.emptyMap();
        }

        //key: checkKey, value: exists key?
        Map<String, Boolean> resultMap = Maps.newHashMap();

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(dbIndex);
            checkKeys.forEach(key -> resultMap.put(key, jedis.exists(key)));
        }
        return resultMap;
    }

    @Override
    public void expire(String key, int second, int dbIndex) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(dbIndex);
            jedis.expire(key, second);
        }
    }

    @Override
    public Integer delMatchedKeys(String prefix, String suffix) {
        try (Jedis jedis = jedisPool.getResource()) {

            String key;

            if (!StringUtils.isEmpty(prefix) && StringUtils.isEmpty(suffix))
                key = prefix + "*";
            else if (StringUtils.isEmpty(prefix) && !StringUtils.isEmpty(suffix))
                key = "*" + suffix;
            else
                return 0;

            Set<String> matchedKeys = jedis.keys(key);
            if (CollectionUtils.isEmpty(matchedKeys))
                return 0;
            Pipeline pipeline = jedis.pipelined();
            matchedKeys.forEach(pipeline::del);
            pipeline.sync();
            return matchedKeys.size();
        }
    }

    @Override
    public void addHash(String key, Map<String, ?> hashData) {
        if (CollectionUtils.isEmpty(hashData))
            return;
        Map<String, String> transformedHashData = Maps.transformValues(hashData, sourceValue -> {
            try {
                if (sourceValue instanceof String) {
                    return (String) sourceValue;
                }
                return objectMapper.writeValueAsString(sourceValue);
            } catch (JsonProcessingException e) {
                return null;
            }
        });

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(3); //all hash data save to no.3 storehouse
            Pipeline pipeline = jedis.pipelined();
            jedis.hmset(key, transformedHashData);
            pipeline.sync();
        }
    }

    @Override
    public void addHashValue(String key, String elementKey, Object data) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(elementKey) || data == null)
            return;
        try (Jedis jedis = jedisPool.getResource()) {
            if (!jedis.exists(key)) {
                HashMap<String, Object> elementMap = Maps.newHashMap();
                elementMap.put(elementKey, data);
                this.addHash(key, elementMap);
            } else {
                try {
                    String stringData = (data instanceof String)
                            ? (String) data
                            : objectMapper.writeValueAsString(data);
                    jedis.hset(key, elementKey, stringData);
                } catch (JsonProcessingException e) {
                    log.warn("transform element to json pattern  fail, reason:", e);
                }
            }
        }
    }

    @Override
    public <T> Map<String, T> getHash(String key, Class<T> tClass) {
        Map<String, String> hashData;
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(3); //all hash data save to no.3 storehouse
            Pipeline pipeline = jedis.pipelined();
            Response<Map<String, String>> response = pipeline.hgetAll(key);
            pipeline.sync();
            if (response == null || CollectionUtils.isEmpty(response.get()))
                return null;
            hashData = response.get();
        }

        return Maps.transformValues(hashData, sourceValue -> {
            try {
                if (tClass == String.class) {
                    return (T) sourceValue;
                }
                return objectMapper.readValue(sourceValue, tClass);
            } catch (IOException e) {
                return null;
            }
        });
    }

    @Override
    public <T> Map<String, T> getHashAll(String key, Class<T> tClass) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(3); //all hash data save to no.3 storehouse
            Map<String, String> hashValues = jedis.hgetAll(key);

            if (hashValues != null) {

                return hashValues.entrySet().parallelStream().collect(Collectors.toMap(Map.Entry::getKey, e -> {
                    try {
                        return objectMapper.readValue(e.getValue(), tClass);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        return null;
                    }
                }));
            }
        }
        return Collections.emptyMap();
    }

    @Override
    public <T> T getHashValue(String hashKey, String mapKey, Class<T> tClass) {
        String hashData;
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(3); //all hash data save to no.3 storehouse
            hashData = jedis.hget(hashKey, mapKey);
        }
        if (StringUtils.isEmpty(hashData)) {
            return null;
        }

        if (tClass == String.class) {
            return (T) hashData;
        }

        try {
            return objectMapper.readValue(hashData, tClass);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void removeHashValue(String hashKey, String mapKey) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(3); //all hash data save to no.3 storehouse
            jedis.hdel(hashKey, mapKey);
        }
    }

    @Override
    public void saveExceptionLog(Exception e, String orderNo) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.select(4);
            jedis.set(orderNo + Constants.DASH + TimeUtils.format(TimeUtils.now()), e.getMessage());
        }
    }
}
