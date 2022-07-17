package com.dubboscaffold.dubboprovider.service.impl;

import com.dubboscaffold.dubboapi.api.TestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(version = "${dubbo.provider.TestService.version}")
public class TestServiceImpl implements TestService {

    @Override
    public String sayhello() {
        return "Hello Dubbo!!!";
    }
}
