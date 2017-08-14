package com.xdy.controller;

import com.xdy.model.UserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: xuedaiyao
 * Date: 2017/8/10
 * Time: 18:31
 * Description:
 */

@RestController
public class HelloController {

    @GetMapping("hello")
    @ApiOperation(value = "第一个Hello world",response = String.class)
    public String hello(){
        return "hello";
    }


    @GetMapping("/json")
    @ApiOperation(value = "测试用户返回",notes = "测试用户返回",response = UserInfo.class)
    public UserInfo json( UserInfo userInfo){
        userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUserName("xuedaiyao");
        userInfo.setPassword("dsfsfsdfsdfd");
        return userInfo;
    }
}
