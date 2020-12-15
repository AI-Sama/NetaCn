package com.xnqn.netacn.model;

import lombok.Data;

import java.util.Date;
@Data
public class UserInfo {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String account;

    private String password;

    private String headImg;

    private Integer language;

    private Integer isUnlimit;

}