package com.xdy.Inteceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class AllRequestInterceptor extends HandlerInterceptorAdapter {
   /* @Autowired
    RedisUtil redisUtil;*/
    Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String currentUser = request.getHeader("Authorization");
        logger.info("当前请求URL==============【{}】", request.getRequestURI());
        Cookie[] cookies = request.getCookies();
        boolean hasCookie = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("uu_id".equals(cookie.getName())) {
                    hasCookie = true;
                    break;
                }
            }
        }

        if (StringUtils.isEmpty(currentUser) && !hasCookie) {
            String token = UUID.randomUUID().toString().replace("-", "");
            int expireTime = 60 * 60 * 24 * 7;
            response.setHeader("Authorization", token);
            Cookie cookie = new Cookie("uu_id", token);
            cookie.setHttpOnly(true);
            cookie.setDomain("");
            cookie.setPath("/");
            cookie.setMaxAge(expireTime);
            response.addCookie(cookie);
//            redisUtil.put("customer:" + token, new Date(), (long) expireTime);
        }
        return true;
    }
}
