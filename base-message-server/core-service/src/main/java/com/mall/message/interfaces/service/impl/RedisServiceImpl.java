package com.mall.message.interfaces.service.impl;

import com.mall.message.interfaces.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedisServiceImpl implements RedisService{

    private final static int DEFAULT_INDEX = 0;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;  //用于修改dbIndex

    @Override
    public Boolean setNX(String key,String value,long expire) {
        Boolean result = redisTemplate.opsForValue().setIfAbsent(key,value);
        if(result){
            redisTemplate.expire(key,expire,TimeUnit.SECONDS);
        }
        return result;
    }

    @Override
    public void put(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void put(String key, String value, int dbIndex) {
        jedisConnectionFactory.setDatabase(dbIndex);
        redisTemplate.opsForValue().set(key,value);
        jedisConnectionFactory.setDatabase(DEFAULT_INDEX);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void del(String key, String value, int dbIndex) {
        jedisConnectionFactory.setDatabase(dbIndex);
        redisTemplate.delete(key);
        jedisConnectionFactory.setDatabase(DEFAULT_INDEX);
    }


    @Override
    public void putObj(String key, int expire, Object obj) {
        redisTemplate.opsForValue().set(key,obj);
    }

    @Override
    public void putObj(String key, int expire, Object obj, int dbIndex) {
        jedisConnectionFactory.setDatabase(dbIndex);
        redisTemplate.opsForValue().set(key,obj);
        jedisConnectionFactory.setDatabase(DEFAULT_INDEX);
    }

    @Override
    public <T> T getObj(String key, Class<T> tClass) {
        return (T)redisTemplate.opsForValue().get(key);
    }

    @Override
    public <T> T getObj(String key, Class<T> tClass, int dbIndex) {
        jedisConnectionFactory.setDatabase(dbIndex);
        T obj = (T)redisTemplate.opsForValue().get(key);
        jedisConnectionFactory.setDatabase(DEFAULT_INDEX);
        return obj;
    }
}
