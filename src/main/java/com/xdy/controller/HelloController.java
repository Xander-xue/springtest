package com.xdy.controller;

import com.github.pagehelper.PageInfo;
import com.xdy.model.UserInfo;
import com.xdy.model.vo.ResponseVO;
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

    @GetMapping()
    @ApiOperation(value = "用户列表", notes = "用户列表")
    public ResponseVO list() {
        return ResponseVO.response().setData(new PageInfo<UserInfo>(userInfoService.list())).build();
    }

    @PostMapping()
    @ApiOperation(value = "添加用户@xdy", notes = "添加用户")
    public ResponseVO save(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        return ResponseVO.response().build();
    }

    @PutMapping()
    @ApiOperation(value = "修改用户@xdy", notes = "修改用户")
    public ResponseVO updateUser(@RequestBody UserInfo userInfo) {
        userInfoService.updateUser(userInfo);
        return ResponseVO.response().build();
    }

    @DeleteMapping()
    @ApiOperation(value = "批量删除用户", notes = "批量删除用户")
    public ResponseVO delUser(@ApiParam(value = "用户ID数组", required = true) @RequestBody Integer[] ids) {//如果使用这种注解来传递数组[7,8]  如果不使用这个注解，传递7,8 即可，不用方括号
        userInfoService.delUser(ids);
        return ResponseVO.response().build();
    }
}
