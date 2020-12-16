package com.xnqn.netacn.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private Date lastLoginTime;

    private String account;

    private String password;

    private String headImg;

    private Byte language;

    private Byte wordLimit;

    private Byte upLimit;

    private Byte loginLimit;

    private Byte power;

    private Integer level;

    private String spare1;

    private String spare2;

    private String spare3;
}