package com.mall.message.interfaces.service;

public interface RedisService {

    Boolean setNX(String key,String value,long expire);

    void put(String key, String value);

    void put(String key, String value, int dbIndex);

    void del(String key);

    void del(String key, String value, int dbIndex);

    void putObj(String key, int expire, Object obj);

    void putObj(String key, int expire, Object obj, int dbIndex);

    <T> T getObj(String key, Class<T> tClass);

    <T> T getObj(String key, Class<T> tClass, int dbIndex);
}
