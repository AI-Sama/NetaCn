package com.xnqn.netacn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel("用户信息")
public class UserInfo {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("头像")
    private String headImg;
    @ApiModelProperty("语言选项")
    private Integer language;
    @ApiModelProperty("限制开关")
    private Integer isUnlimit;

}