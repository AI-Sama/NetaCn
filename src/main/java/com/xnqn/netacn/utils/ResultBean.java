package com.xnqn.netacn.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/15 16:57
 * @Description: 返回结果工具类
 */
@ApiModel("返回结果类")
@Data
public class ResultBean<T>{
    @ApiModelProperty("返回码，默认为1(成功)")
    private Integer resultCode = 1;
    @ApiModelProperty("返回信息")
    private String resultMsg = "OK";
    @ApiModelProperty("返回数据")
    private T resultData = null;

    public ResultBean(){}

    public ResultBean(T resultData) {
        this.resultData = resultData;
    }

    public ResultBean(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public ResultBean( String resultMsg, T resultData) {
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    public ResultBean(Integer resultCode, String resultMsg, T resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

}
