package com.xnqn.netacn.controller;

import com.xnqn.netacn.model.UserInfo;
import com.xnqn.netacn.service.impl.UserInfoImpl;
import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @ApiOperation("修改用户信息")
    @PostMapping(value = "/updateUser", produces = {"application/json;charset=utf-8"})
    public ResultBean updateUser(@RequestBody UserInfo userInfo) {
        log.info("修改用户信息：" + userInfo.toString());

        return new ResultBean();
    }

    @ApiOperation("添加用户")
    @PostMapping(value = "/addUser", produces = {"application/json;charset=utf-8"})
    public ResultBean addUser(@RequestBody UserInfo userInfo) {
        log.info("添加用户：" + userInfo.toString());
        switch (userInfoService.addUser(userInfo)) {
            case 0:
                return new ResultBean(0, "该账号已被注册");
        }
        return new ResultBean();
    }

    @ApiOperation("登录")
    @PostMapping(value = "/userLogin", produces = {"application/json;charset=utf-8"})
    public ResultBean userLogin(@RequestBody UserInfo userInfo) {
        UserInfo returnUser = userInfoService.userLogin(userInfo);
        if (returnUser == null) {
            return new ResultBean(0, "账号或密码错误");
        }
        return new ResultBean(returnUser);
    }

    @ApiOperation("查找用户信息")
    @GetMapping(value = "/getUserInfo", produces = {"application/json;charset=utf-8"})
    public ResultBean getUserInfo(HttpServletRequest httpServletRequest) {
        UserInfo userInfo = userInfoService.selectUser(httpServletRequest.getAttribute("userAccount").toString());
        userInfo.setUserPassword(null);
        return new ResultBean(userInfo);
    }

    @ApiOperation("test")
    @GetMapping(value = "/test", produces = {"application/json;charset=utf-8"})
    public ResultBean test() {
        return new ResultBean();
    }
}
