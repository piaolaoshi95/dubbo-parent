package com.dubboscaffold.sys.user.service;

import com.dubboscaffold.dubboapi.entity.User;

public interface SysUserService {

    User getUserByUsername(String username);

}
