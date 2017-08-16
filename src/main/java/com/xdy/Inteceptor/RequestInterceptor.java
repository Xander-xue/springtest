package com.xdy.Inteceptor;

import com.xdy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (C), 2011-2017 温州贷
 * FileName: com.wzd.util.RequestInteceptor.java
 * Author: shijikun
 * Email: shijikun@wzdai.com
 * Date: 2017/6/6 18:21
 * Description:拦截请求,检查用户是否登录
 * History:
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String currentUser = request.getHeader("Authorization");
        request.setAttribute("usrId", userInfoService.getLoginUser(currentUser).getId());
        return true;
    }
}
