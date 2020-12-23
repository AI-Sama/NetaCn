package com.xnqn.netacn.controller;

import com.xnqn.netacn.model.UserInfo;
import com.xnqn.netacn.service.impl.UserInfoImpl;
import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class UserController {
    @Autowired
    UserInfoImpl userInfoService;

    @ApiOperation("添加用户")
    @PostMapping(value = "/addUser", produces = {"application/json;charset=utf-8"})
    public ResultBean addUser(@RequestBody UserInfo userInfo) {
        log.info("日志：" + userInfo.toString());
        switch (userInfoService.addUser(userInfo)) {
            case 0:
                return new ResultBean(0, "该账号已被注册");
        }
        return new ResultBean();
    }

    @ApiOperation("登录")
    @PostMapping(value = "/userLogin", produces = {"application/json;charset=utf-8"})
    public ResultBean userLogin(@RequestBody UserInfo userInfo) {
        log.info("日志：" + userInfo.toString());
        UserInfo returnUser=userInfoService.userLogin(userInfo);
        if(returnUser==null){
            return new ResultBean(0,"账号或密码错误");
        }
        return new ResultBean(returnUser);
    }
}
