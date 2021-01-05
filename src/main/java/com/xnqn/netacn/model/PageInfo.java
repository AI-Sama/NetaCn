package com.xnqn.netacn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2021/1/4 16:13
 * @Description:
 */
@ApiModel("分页")
@Data
public class PageInfo<T> {
    @ApiModelProperty("排序状态")
    private Integer status = 0;
    @ApiModelProperty("是否开启屏蔽")
    private Integer pb = 1;
    @ApiModelProperty("查询词语")
    private String selectWord;
    @ApiModelProperty("查询页面")
    private Integer pageNum = 1;
    @ApiModelProperty("查询大小")
    private Integer pageSize = 10;
    private Integer total = 0;
    private T data;

    public PageInfo() {
    }

    public PageInfo(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
