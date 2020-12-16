package com.xnqn.netacn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@ApiModel("用户表")
@Data
public class UserInfo {
    private Integer userId;

    private Date gmtCreate;

    private Date gmtModified;
    @ApiModelProperty("最后登陆时间")
    private Date lastLoginTime;
    @ApiModelProperty("账号")
    private String userAccount;
    @ApiModelProperty("密码")
    private String userPassword;
    @ApiModelProperty("头像")
    private String headImg;
    @ApiModelProperty("语言")
    private Byte userLanguage;
    @ApiModelProperty("词语限制")
    private Byte wordLimit;
    @ApiModelProperty("上传限制")
    private Byte upLimit;
    @ApiModelProperty("登陆限制")
    private Byte loginLimit;
    @ApiModelProperty("账号权限")
    private Byte userPower;
    @ApiModelProperty("账号等级")
    private Byte userLevel;

    private String spare1;

    private String spare2;

    private String spare3;

}