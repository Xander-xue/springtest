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
 * Author: shijikun
 * Email: shijikun@wzdai.com
 * Date: 2017/6/7 10:01
 * Description:
 * History:
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    RequestInterceptor requestInterceptor;
    @Autowired
    AllRequestInterceptor allRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(allRequestInterceptor).addPathPatterns("/**");
        registry.addInterceptor(requestInterceptor)
                .addPathPatterns("/**")

                .excludePathPatterns("/usr/login_quick")
        ;
        super.addInterceptors(registry);
    }
}