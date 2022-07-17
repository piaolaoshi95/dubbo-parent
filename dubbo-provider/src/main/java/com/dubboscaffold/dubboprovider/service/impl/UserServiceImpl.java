package com.dubboscaffold.dubboprovider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dubboscaffold.dubboapi.api.UserService;
import com.dubboscaffold.dubboapi.entity.User;
import com.dubboscaffold.dubboprovider.dao.RedisDao;
import com.dubboscaffold.dubboprovider.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@Service(timeout = 10000)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisDao redisDao;

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> selectByIds(Collection<Integer> ids) {
        return userMapper.selectByIds(ids);
    }

    @Override
    public IPage<User> selectPageByCreateTime(IPage<User> page, String createTime) {
        return userMapper.selectPageByCreateTime(page,createTime);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User selectByIdRedis(Integer id) {
        return redisDao.get(id);
    }

    @Override
    public void insertByIdRedis(Integer id,User user) {
        redisDao.set(id,user);
    }
}
