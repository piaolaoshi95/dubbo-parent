package com.dubboscaffold.dubboconsumer.modular.auth.login.controller;

import com.dubboscaffold.dubboapi.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @RequestMapping("/login")
    public Result selectByUsername(String username, String password){

        return new Result(200);
    }
}
