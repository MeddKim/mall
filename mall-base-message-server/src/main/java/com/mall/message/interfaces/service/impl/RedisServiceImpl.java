package com.mall.message.interfaces.service.impl;

import com.mall.message.interfaces.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisServiceImpl implements RedisService{

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;  //用于修改dbIndex

    @Override
    public Boolean setNX(String key,long expire) {
//        return redisTemplate.expire(key,expire, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("12121212","呵呵呵");
        return stringRedisTemplate.expire("12121212",expire,TimeUnit.SECONDS);
    }

    @Override
    public void put(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void put(String key, int expire, String value) {

    }

    @Override
    public void put(String key, int expire, String value, int dbIndex) {

    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public String get(String key, int dbIndex) {
        return null;
    }

    @Override
    public <T> T getOrDefault(String key, T defaultValue) {
        return null;
    }

    @Override
    public <T> T getOrDefault(String key, T defaultValue, int expire) {
        return null;
    }

    @Override
    public <T> T getOrDefault(String key, T defaultValue, int expire, int dbIndex) {
        return null;
    }

    @Override
    public <T> T getOrDefaultSystemVariable(String key, T defaultValue) {
        return null;
    }

    @Override
    public <T> T getOrDefaultSystemVariable(String key, T defaultValue, int expire) {
        return null;
    }

    @Override
    public <T> T getOrDefaultSystemVariable(String key, T defaultValue, int expire, int dbIndex) {
        return null;
    }

    @Override
    public void del(String key) {
        jedisConnectionFactory.setDatabase(5);
        redisTemplate.delete(key);
    }

    @Override
    public void del(String key, int dbIndex) {

    }

    @Override
    public void putObj(String key, int expire, Object obj) {
        jedisConnectionFactory.setDatabase(5);
        redisTemplate.opsForValue().set(key,obj);
    }

    @Override
    public void putObj(String key, int expire, Object obj, int dbIndex) {

    }

    @Override
    public <T> T getObj(String key, Class<T> tClass) {
        jedisConnectionFactory.setDatabase(5);
        return (T)redisTemplate.opsForValue().get(key);
    }

    @Override
    public <T> T getObj(String key, Class<T> tClass, int dbIndex) {
        return null;
    }

    @Override
    public void setAdd(String key, Collection<?> objects) {

    }

    @Override
    public void setAdd(String key, Collection<?> objects, int expire) {

    }

    @Override
    public Set<?> setMembers(String key, Class<?> tClass) {
        return null;
    }

    @Override
    public <T> List<T> getList(String key, Class<T> tClass) {
        return null;
    }

    @Override
    public boolean exists(String key) {
        return false;
    }

    @Override
    public boolean exists(String key, int dbIndex) {
        return false;
    }

    @Override
    public Map<String, Boolean> checkExists(List<String> checkKeys) {
        return null;
    }

    @Override
    public Map<String, Boolean> checkExists(List<String> checkKeys, int dbIndex) {
        return null;
    }

    @Override
    public void expire(String key, int second) {

    }

    @Override
    public void expire(String key, int second, int dbIndex) {

    }

    @Override
    public Integer delMatchedKeys(String keyPrefix, String suffix) {
        return null;
    }

    @Override
    public void addHash(String key, Map<String, ?> hashData) {

    }

    @Override
    public void addHashValue(String key, String elementKey, Object data) {

    }

    @Override
    public <T> Map<String, T> getHash(String key, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> Map<String, T> getHashAll(String key, Class<T> tClass) {
        return null;
    }

    @Override
    public <T> T getHashValue(String hashKey, String mapKey, Class<T> tClass) {
        return null;
    }

    @Override
    public void removeHashValue(String hashKey, String mapKey) {

    }

    @Override
    public void saveExceptionLog(Exception e, String orderNo) {

    }
}
