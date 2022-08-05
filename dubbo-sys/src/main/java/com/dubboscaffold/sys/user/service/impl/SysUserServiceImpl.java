package com.dubboscaffold.sys.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dubboscaffold.dubboapi.entity.User;
import com.dubboscaffold.sys.enums.CommonStatusEnum;
import com.dubboscaffold.sys.user.mapper.SysUserMapper;
import com.dubboscaffold.sys.user.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, User> implements SysUserService {


    @Override
    public User getUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        queryWrapper.ne(User::getDeleted, CommonStatusEnum.DELETED.getCode());
        return this.getOne(queryWrapper);
    }

}
