package com.xnqn.netacn.controller;

import com.xnqn.netacn.model.NetaLabel;
import com.xnqn.netacn.service.impl.NetaLabelImpl;
import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/22 18:52
 * @Description:
 */
@RestController
@RequestMapping("/label")
@Api(tags = "标签模块")
public class NetaLabelController {

    @Autowired
    NetaLabelImpl netaLabel;

    @ApiOperation("添加标签")
    @PostMapping(value = "/addLabel", produces = {"application/json;charset=utf-8"})
    public ResultBean addLabel(@RequestBody NetaLabel netaLabel) {
        //todo 添加标签
        return new ResultBean();
    }

    @ApiOperation("获取全部标签")
    @GetMapping(value = "/getLabels", produces = {"application/json;charset=utf-8"})
    public ResultBean getLabels() {
        
        return new ResultBean(netaLabel.selectLabels());
    }
}
