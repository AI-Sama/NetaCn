package com.xnqn.netacn.controller;

import com.xnqn.netacn.model.NetaLabel;
import com.xnqn.netacn.service.impl.NetaLabelImpl;
import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/22 18:52
 * @Description:
 */
@RestController
@RequestMapping("/label")
@Api(tags = "标签模块")
@Slf4j
public class NetaLabelController {

    @Autowired
    NetaLabelImpl netaLabelimpl;

    @ApiOperation("添加标签")
    @PostMapping(value = "/addLabel", produces = {"application/json;charset=utf-8"})
    public ResultBean addLabel() {
        //todo 添加标签
        List<NetaLabel> labels=new ArrayList<>();
        NetaLabel netaLabel=new NetaLabel();
        netaLabel.setCnWord("测试3");
        netaLabel.setJpWord("Test3");
        NetaLabel netaLabe2=new NetaLabel();
        netaLabe2.setCnWord("测试4");
        netaLabe2.setJpWord("Test4");
        labels.add(netaLabel);
        labels.add(netaLabe2);
        log.info(labels.toString());
        netaLabelimpl.addLabel(labels);
        return new ResultBean();
    }

    @ApiOperation("获取全部标签")
    @GetMapping(value = "/getLabels", produces = {"application/json;charset=utf-8"})
    public ResultBean getLabels() {

        return new ResultBean(netaLabelimpl.selectLabels());
    }
    @ApiOperation("模糊查询标签")
    @GetMapping(value = "/getLabel", produces = {"application/json;charset=utf-8"})
    public ResultBean getLabel(@RequestBody String LabelName) {
        //todo 模糊查询标签
        return new ResultBean();
    }
}
