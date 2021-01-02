package com.xnqn.netacn.controller;

import com.xnqn.netacn.model.Neta;
import com.xnqn.netacn.model.NetaLabel;
import com.xnqn.netacn.service.impl.NetaImpl;
import com.xnqn.netacn.service.impl.NetaLabelImpl;
import com.xnqn.netacn.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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
    @Autowired
    NetaLabelImpl netaLabel;
    @ApiOperation("测试方法")
    @GetMapping(value = "/test", produces = {"application/json;charset=utf-8"})
    public ResultBean test() {
        return new ResultBean();
    }

    @ApiOperation("添加neta")
    @PostMapping(value = "/addNeta", produces = {"application/json;charset=utf-8"})
    public ResultBean addNeta(@RequestBody Neta neta, HttpServletRequest httpServletRequest) {
        neta.setUpUser((String) httpServletRequest.getAttribute("userAccount"));
        String label = neta.getNetaLabel();
        String[] labels = label.split("\\|");
        ArrayList<NetaLabel> labelArrayList=new ArrayList<>();
        for(int x=0;x<labels.length;x++){
            labelArrayList.add(new NetaLabel(labels[x]));
        }
        netaLabel.addLabel(labelArrayList);
        label="";
        for(int x=0;x<labelArrayList.size();x++){
            label+=labelArrayList.get(x).getLabelId();
            if(x!=labelArrayList.size()-1){
                label+="|";
            }
        }
        neta.setNetaLabel(label);
        netaimpl.addNeta(neta);
        return new ResultBean();
    }
}
