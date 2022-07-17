package com.dubboscaffold.dubboconsumer.controller;

import com.dubboscaffold.dubboapi.api.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @Reference(version = "${dubbo.consumer.TestService.version}")
    private TestService testService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return testService.sayhello();
    }

}
