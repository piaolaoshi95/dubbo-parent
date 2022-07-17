package com.dubboscaffold.dubboconsumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /*解决跨域问题*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//项目中所有接口都支持跨域
                .allowedOrigins("*")//前端哪些域名可以跨域（这里是全部都可以）
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")//允许所有请求方式
                .allowCredentials(true)//自己的的项目需要带cookie凭证
                .maxAge(3600)//跨域允许时间
                .allowedHeaders("*");//请求信息所有
    }
}
