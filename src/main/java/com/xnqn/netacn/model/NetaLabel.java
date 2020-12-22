package com.xnqn.netacn.model;

import java.util.Date;

public class NetaLabel {
    private Integer labelId;

    private Date gmtCreate;

    private Date gmtModified;

    private String cnWord;

    private String jpWord;

    private String spare1;

    private String spare2;

    private String spare3;

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getCnWord() {
        return cnWord;
    }

    public void setCnWord(String cnWord) {
        this.cnWord = cnWord == null ? null : cnWord.trim();
    }

    public String getJpWord() {
        return jpWord;
    }

    public void setJpWord(String jpWord) {
        this.jpWord = jpWord == null ? null : jpWord.trim();
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1 == null ? null : spare1.trim();
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2 == null ? null : spare2.trim();
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3 == null ? null : spare3.trim();
    }
}