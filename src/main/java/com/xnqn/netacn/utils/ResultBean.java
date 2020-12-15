package com.xnqn.netacn.utils;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/15 16:57
 * @Description: 返回结果工具类
 */
public class ResultBean<T>{
    //返回码，默认为 1
    private Integer resultCode = 1;
    //返回信息
    private String resultMsg = "OK";
    //返回数据
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
