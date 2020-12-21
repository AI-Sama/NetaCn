package com.xnqn.netacn.controller;

import com.xnqn.netacn.model.UserInfo;
import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/15 16:33
 * @Description:
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户模块")
public class UserController {


    @ApiOperation("添加用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "insert",name = "userInfo",value = "用户信息",required = true)
    })
    @PostMapping(value = "/addUser",produces = {"application/json;charset=utf-8"})
    public ResultBean addUser(@RequestBody UserInfo userInfo){

        //todo 添加用户
        System.out.println();
        System.out.println("Hello World");
        return new ResultBean();
    }
}
