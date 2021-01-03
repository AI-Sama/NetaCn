package com.xnqn.netacn.controller;

import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/24 18:55
 * @Description:
 */
@RestController
@Api("错误控制器")
@RequestMapping("/error")
public class ErrorController {

    @ApiOperation("token校验失败")
    @GetMapping(value = "/errorToken", produces = {"application/json;charset=utf-8"})
    public ResultBean errorToken(HttpServletRequest httpServletRequest) {
        return new ResultBean((int)httpServletRequest.getAttribute("code"), "token校验失败");
    }

}
