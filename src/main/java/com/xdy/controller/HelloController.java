package com.xdy.controller;

import com.xdy.model.UserInfo;
import com.xdy.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * User: xuedaiyao
 * Date: 2017/8/10
 * Time: 18:31
 * Description:
 */

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping()
    @ApiOperation(value = "添加用户@xdy",notes = "添加用户")
    public void save(@RequestBody  UserInfo userInfo){
         userInfoService.save(userInfo);
    }

    @PutMapping()
    @ApiOperation(value = "修改用户@xdy",notes = "修改用户")
    public void updateUser(@RequestBody UserInfo userInfo){
        userInfoService.updateUser(userInfo);
    }

    @DeleteMapping()
    @ApiOperation(value = "批量删除用户",notes = "批量删除用户")
    public void delUser( @ApiParam(value = "用户ID数组", required = true)@RequestBody Integer[] ids){//如果使用这种注解来传递数组[7,8]  如果不使用这个注解，传递7,8 即可，不用方括号
        userInfoService.delUser(ids);
    }
}
