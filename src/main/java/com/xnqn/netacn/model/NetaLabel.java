package com.xnqn.netacn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("标签表")
@Data
public class NetaLabel {
    private Integer labelId;
    private Date gmtCreate;
    private Date gmtModified;
    @ApiModelProperty("中文解释")
    private String cnWord;
    @ApiModelProperty("日语解释")
    private String jpWord;
    private String spare1;
    private String spare2;
    private String spare3;
}