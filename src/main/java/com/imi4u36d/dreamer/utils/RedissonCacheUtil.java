package com.imi4u36d.dreamer.utils;

import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * redisson操作缓存工具类
 */
@Component
public class RedissonCacheUtil {

    @Autowired
    RedissonClient redissonClient;

    public void setString(String key, String value) {
        RBucket<String> bucket = redissonClient.getBucket(key);
        bucket.set(value);
    }

    public String getString(String key) {
        RBucket<String> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    public void setList(String key, List<String> values) {
        RList<String> list = redissonClient.getList(key);
        list.addAll(values);
    }

    public void addToList(String key, String value) {
        RList<String> list = redissonClient.getList(key);
        list.add(value);
    }

    public RList<String> getList(String key) {
        return redissonClient.getList(key);
    }

    public void setSet(String key, Set<String> values) {
        RSet<String> set = redissonClient.getSet(key);
        set.addAll(values);
    }

    public void addToSet(String key, String value) {
        RSet<String> set = redissonClient.getSet(key);
        set.add(value);
    }

    public RSet<String> getSet(String key) {
        return redissonClient.getSet(key);
    }

    public void setMap(String key, String field, String value) {
        RMap<String, String> map = redissonClient.getMap(key);
        map.put(field, value);
    }

    public String getMap(String key, String field) {
        RMap<String, String> map = redissonClient.getMap(key);
        return map.get(field);
    }
}
