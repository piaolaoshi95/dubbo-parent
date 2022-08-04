package com.dubboscaffold.sys.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/sys")
@Api(value = "登录模块", tags = "登录模块")
public class SysLoginController {
}
