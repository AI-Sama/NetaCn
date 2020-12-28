package com.xnqn.netacn.controller;

import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/28 16:48
 * @Description:
 */
@RestController
@Api("词语模块")
@RequestMapping("/neta")
public class NetaController {

    @ApiOperation("test")
    @GetMapping(value = "/test", produces = {"application/json;charset=utf-8"})
    public ResultBean test() {
        return new ResultBean();
    }
}
