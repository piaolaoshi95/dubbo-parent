package com.dubboscaffold.dubboprovider.dao;

import com.dubboscaffold.dubboapi.entity.User;
import com.dubboscaffold.dubboapi.util.JSONUtil;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RedisDao {

    @Resource(name = "redisTemplate")
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ValueOperations<String, String> operations;

    private static final String KEY_PATTERN = "user:%d";



    private static String buildKey(Integer id) {
        return String.format(KEY_PATTERN, id);
    }

    public User get(Integer id) {
        String key = buildKey(id);
        String value = operations.get(key);
        return JSONUtil.parseObject(value, User.class);
    }

    public void set(Integer id, User user) {
        String key = buildKey(id);
        String value = JSONUtil.toJSONString(user);
        operations.set(key, value);
    }
}
