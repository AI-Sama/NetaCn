package com.xnqn.netacn.controller;

import com.xnqn.netacn.model.Neta;
import com.xnqn.netacn.model.NetaLabel;
import com.xnqn.netacn.model.PageInfo;
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
import java.util.List;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/28 16:48
 * @Description:
 */
@RestController
@Api(tags ="词语模块")
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
        if(neta==null){
            return new ResultBean(0,"未知错误");
        }
        neta.setUpUser((String) httpServletRequest.getAttribute("userAccount"));
        String label = neta.getNetaLabel();
        if(label!=null&&label.length()>0) {
            String[] labels = label.split("\\|");
            if (labels.length > 5) {
                return new ResultBean(0, "标签最多只能有5个");
            }
            ArrayList<NetaLabel> labelArrayList = new ArrayList<>();
            for (int x = 0; x < labels.length; x++) {
                labelArrayList.add(new NetaLabel(labels[x]));
            }
            netaLabel.addLabel(labelArrayList);
            label = "";
            for (int x = 0; x < labelArrayList.size(); x++) {
                label += labelArrayList.get(x).getLabelId();
                if (x != labelArrayList.size() - 1) {
                    label += "|";
                }
            }
            neta.setNetaLabel(label);
        }
        netaimpl.addNeta(neta);
        return new ResultBean();
    }


    @ApiOperation("查找审核neta")
    @GetMapping(value = "/selectJudgeNetas", produces = {"application/json;charset=utf-8"})
    public ResultBean selectJudgeNetas() {
        return new ResultBean(netaimpl.selectJudgeNetas());
    }

    @ApiOperation("点赞")
    @GetMapping(value = "/likeClick", produces = {"application/json;charset=utf-8"})
    public ResultBean likeClick() {
        //todo 点赞
        return new ResultBean();
    }

    @ApiOperation("收藏")
    @GetMapping(value = "/starClick", produces = {"application/json;charset=utf-8"})
    public ResultBean starClick() {
        //todo 收藏
        return new ResultBean();
    }
    @ApiOperation("修改")
    @GetMapping(value = "/updateNeta", produces = {"application/json;charset=utf-8"})
    public ResultBean updateNeta() {
        //todo 修改
        return new ResultBean();
    }
    @ApiOperation("查找neta")
    @GetMapping(value = "/selectNetas", produces = {"application/json;charset=utf-8"})
    public ResultBean selectNetas(@ModelAttribute PageInfo pageInfo) {
        return new ResultBean(netaimpl.selectNetas(pageInfo));
    }

    @ApiOperation("查找详细资料")
    @GetMapping(value = "/selectFullNeta", produces = {"application/json;charset=utf-8"})
    public ResultBean selectFullNeta(Integer netaId) {
        return new ResultBean(netaimpl.selectFullNeta(netaId));
    }

    @ApiOperation("更新状态")
    @PostMapping(value = "/updateNetaStatus", produces = {"application/json;charset=utf-8"})
    public ResultBean updateNetaStatus(@RequestBody List<Neta> netas) {
        log.info(netas.toString());
        netaimpl.changeNetaStatus(netas);
        return new ResultBean();
    }
}
