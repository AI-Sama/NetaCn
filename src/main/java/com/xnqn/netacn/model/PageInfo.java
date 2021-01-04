package com.xnqn.netacn.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2021/1/4 16:13
 * @Description:
 */
@ApiModel("分页")
@Data
public class PageInfo <T>{
    private  Integer pageNum=1;
    private  Integer pageSize=10;
    private  Integer total;
    private  T data;

    public PageInfo() {
    }

    public PageInfo(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
