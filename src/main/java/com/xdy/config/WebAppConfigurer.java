package com.xdy.config;

import com.xdy.Inteceptor.AllRequestInterceptor;
import com.xdy.Inteceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Copyright (C), 2011-2017 温州贷
 * FileName: WebAppConfigurer.java
 * Author: xuedaiyao
 * Date: 2017/6/7 10:01
 * Description:
 * History:
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    private  RequestInterceptor requestInterceptor;
    @Autowired
    private AllRequestInterceptor allRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则  添加需要权限拦截的接口
        // excludePathPatterns 用户排除拦截  需要排序的比如用户登录或者对所有人开放的接口
        registry.addInterceptor(allRequestInterceptor).addPathPatterns("/**");
        registry.addInterceptor(requestInterceptor)
                .addPathPatterns("")

                .excludePathPatterns("")
        ;
        super.addInterceptors(registry);
    }
}