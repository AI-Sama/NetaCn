package com.xnqn.netacn.controller;

import com.xnqn.netacn.model.Neta;
import com.xnqn.netacn.service.impl.NetaImpl;
import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/28 16:48
 * @Description:
 */
@RestController
@Api("词语模块")
@Slf4j
@RequestMapping("/neta")
public class NetaController {
    @Autowired
    NetaImpl netaimpl;

    @ApiOperation("测试方法")
    @GetMapping(value = "/test", produces = {"application/json;charset=utf-8"})
    public ResultBean test() {
        return new ResultBean();
    }

    @ApiOperation("添加neta")
    @PostMapping(value = "/addNeta", produces = {"application/json;charset=utf-8"})
    public ResultBean addNeta(@RequestBody Neta neta) {
        log.info(neta.toString());
        return new ResultBean();
    }
}
