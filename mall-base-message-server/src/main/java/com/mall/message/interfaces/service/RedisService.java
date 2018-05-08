package com.mall.message.interfaces.service;

import com.mall.core.domain.utils.Constants;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {
    // expire: seconds

    Boolean setNX(String key,long expire);

    default void put(String key, String value) {
        put(key, Constants.TIME_OF_ONE_DAY, value);
    }

    default void put(String key, int expire, String value) {
        put(key, expire, value, 0);
    }

    void put(String key, int expire, String value, int dbIndex);

    default String get(String key) {
        return get(key, 0);
    }

    String get(String key, int dbIndex);

    default <T> T getOrDefault(String key, T defaultValue) {
        return getOrDefault(key, defaultValue, Constants.TIME_OF_ONE_DAY);
    }

    default <T> T getOrDefault(String key, T defaultValue, int expire) {
        return getOrDefault(key, defaultValue, expire, 0);
    }

    <T> T getOrDefault(String key, T defaultValue, int expire, int dbIndex);

    default <T> T getOrDefaultSystemVariable(String key, T defaultValue) {
        return getOrDefaultSystemVariable(key, defaultValue, Constants.TIME_OF_ONE_DAY);
    }

    default <T> T getOrDefaultSystemVariable(String key, T defaultValue, int expire) {
        return getOrDefaultSystemVariable(key, defaultValue, expire, 3);
    }

    <T> T getOrDefaultSystemVariable(String key, T defaultValue, int expire, int dbIndex);


    default void del(String key) {
        del(key, 0);
    }

    void del(String key, int dbIndex);


    default void putObj(String key, int expire, Object obj) {
        putObj(key, expire, obj, 0);
    }

    void putObj(String key, int expire, Object obj, int dbIndex);

    default <T> T getObj(String key, Class<T> tClass) {
        return getObj(key, tClass, 0);
    }

    <T> T getObj(String key, Class<T> tClass, int dbIndex);

    default void setAdd(String key, Collection<?> objects) {
        setAdd(key, objects, Constants.TIME_OF_ONE_DAY);
    }

    void setAdd(String key, Collection<?> objects, int expire);

    Set<?> setMembers(String key, Class<?> tClass);

    <T> List<T> getList(String key, Class<T> tClass);

    default boolean exists(String key) {
        return exists(key, 0);
    }

    boolean exists(String key, int dbIndex);

    default Map<String, Boolean> checkExists(List<String> checkKeys) {
        return checkExists(checkKeys, 0);
    }

    Map<String, Boolean> checkExists(List<String> checkKeys, int dbIndex);

    default void expire(String key, int second) {
        expire(key, second, 0);
    }

    void expire(String key, int second, int dbIndex);

    Integer delMatchedKeys(String keyPrefix, String suffix);

    /**
     * insert map pattern<String,Object> to redis cache
     *
     * @param key      redis key
     * @param hashData hashmap
     */
    void addHash(String key, Map<String, ?> hashData);

    /**
     * add element to redis hashmap（ this map must exists）
     *
     * @param key        redis key
     * @param elementKey map key
     * @param data       map value
     */
    void addHashValue(String key, String elementKey, Object data);

    /**
     * get hashmap from redis cache
     *
     * @param key    redis key
     * @param tClass reflection source class name
     * @param <T>    reflection source class type
     * @return reflected map
     */
    <T> Map<String, T> getHash(String key, Class<T> tClass);

    <T> Map<String, T> getHashAll(String key, Class<T> tClass);

    /**
     * get element from redis cached map
     *
     * @param hashKey redis key
     * @param mapKey  map key
     * @param tClass  reflection source class name
     * @param <T>     reflection source class value
     * @return reflected object
     */
    <T> T getHashValue(String hashKey, String mapKey, Class<T> tClass);

    /**
     * remove element from hashmap
     *
     * @param hashKey redis key
     * @param mapKey  mapKey
     */
    void removeHashValue(String hashKey, String mapKey);

    void saveExceptionLog(Exception e, String orderNo);
}
