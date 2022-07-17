package com.dubboscaffold.dubboconsumer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dubboscaffold.dubboapi.api.UserService;
import com.dubboscaffold.dubboapi.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/insertDemo")
    public void insertUser(){
        User user = new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword("123");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userService.insertUser(user);
    }

    @RequestMapping("/selectByUsername")
    public User selectByUsername(String username){
        return userService.selectByUsername(username);
    }

    @RequestMapping("/selectByIds")
    public List<User> selectByIds(String ids){
        String[] idArr = ids.split(",");
        List list = Arrays.asList(idArr);
        return userService.selectByIds(list);
    }

    @RequestMapping("/selectPageByCreateTime")
    public IPage selectPageByCreateTime(int currentPage,int pageSize,String createTime){
        //int currentPage = 1; //当前页数：显示第一页数据
        //Integer pageSize = 2;    //每页显示多少：每页显示2条数据
        Page<User> page = new Page<User>(currentPage,pageSize);
        return userService.selectPageByCreateTime(page,createTime);
    }

    @RequestMapping("/selectByIdRedis")
    public User selectByIdRedis(Integer id){
        return userService.selectByIdRedis(id);
    }

    @RequestMapping("/insertByIdRedis")
    public void insertByIdRedis(String username,Integer id){
        User user = new User();
        user.setUsername(username);
        user.setPassword("123");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        user.setId(id);
        userService.insertByIdRedis(user.getId(),user);
    }

}
