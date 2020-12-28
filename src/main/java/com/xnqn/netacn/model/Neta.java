package com.xnqn.netacn.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("词语表")
public class Neta {
    private Integer netaId;

    private Date gmtCreate;

    private Date gmtModified;

    private String netaWord;

    private String upUser;

    private String pinyin;

    private String katakana;

    private String netaLabel;

    private Byte wordShield;

    private Integer netaDate;

    private String cnExplanation;

    private String jpExplanation;

    private Byte netaStatus;

    private Integer likeNum;

    private Integer lookNum;

    private Integer starNum;

    private String reason;

    private String spare1;

    private String spare2;

    private String spare3;

}