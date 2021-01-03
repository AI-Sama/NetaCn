package com.xnqn.netacn.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("词语表")
public class Neta {
    private Integer netaId;

    private Date gmtCreate;

    private Date gmtModified;
    @ApiModelProperty("词语")
    private String netaWord;
    @ApiModelProperty("上传人")
    private String upUser;
    @ApiModelProperty("拼音，多个用空格隔开")
    private String pinyin;
    @ApiModelProperty("假名注音")
    private String katakana;
    @ApiModelProperty("标签，多个用|隔开")
    private String netaLabel;
    @ApiModelProperty("是否限制，默认1限制")
    private Byte wordShield;
    @ApiModelProperty("出现日期")
    private Integer netaDate;
    @ApiModelProperty("中文释义")
    private String cnExplanation;
    @ApiModelProperty("日语释义")
    private String jpExplanation;
    @ApiModelProperty("状态")
    private Byte netaStatus;
    @ApiModelProperty("点赞数")
    private Integer likeNum;
    @ApiModelProperty("观看数")
    private Integer lookNum;
    @ApiModelProperty("收藏数")
    private Integer starNum;
    @ApiModelProperty("拒绝原因")
    private String reason;

    private String spare1;

    private String spare2;

    private String spare3;

}