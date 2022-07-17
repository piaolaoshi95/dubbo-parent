package com.dubboscaffold.dubboapi.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dubboscaffold.dubboapi.entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {

    User selectByUsername(String username);

    List<User> selectByIds(Collection<Integer> ids);

    IPage<User> selectPageByCreateTime(IPage<User> page, String createTime);

    void insertUser(User user);

    User selectByIdRedis(Integer id);

    void insertByIdRedis(Integer id,User user);
}
