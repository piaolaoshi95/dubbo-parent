package com.dubboscaffold.dubboconsumer.controller;

import com.dubboscaffold.dubboapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/setKeyByRedis")
    public void setKeyByRedis(){
        stringRedisTemplate.opsForValue().set("redis", "hello");
    }

    /**
     * 测试redis序列化
     */
    @RequestMapping("/setEntityJsonByRedis")
    public void setEntityJsonByRedis(){
        User user = new User();
        user.setId(1);
        user.setUsername("redis");
        user.setDeleted(0);
        String key = String.format("user:%d", user.getId());
        redisTemplate.opsForValue().set(key, user);
    }

    @RequestMapping("/getEntityJsonByRedis")
    public Object getEntityJsonByRedis() {
        String key = String.format("user:%d", 1);
        Object value = redisTemplate.opsForValue().get(key);
        System.out.println(value);
        return value;
    }
}
