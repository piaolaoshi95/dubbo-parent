package com.dubboscaffold.sys.auth.service.impl;

import com.dubboscaffold.dubboapi.entity.User;
import com.dubboscaffold.sys.auth.model.param.AuthParam;
import com.dubboscaffold.sys.auth.service.AuthService;
import com.dubboscaffold.sys.user.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public String login(AuthParam authParam) {

        User user = sysUserService.getUserByUsername(authParam.getUsername());

        //用户不存在，账号或密码错误
        if (null==user) {
            throw new RuntimeException("用户不存在，账号或密码错误");
        }

        if(authParam.getPassword().equals(user.getPassword())){

        }

        return this.doLogin(user);
    }

    private String doLogin(User user) {

        return null;
    }
}
