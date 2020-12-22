package com.xnqn.netacn.mapper;

import com.xnqn.netacn.model.NetaLabel;

public interface NetaLabelMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(NetaLabel record);

    int insertSelective(NetaLabel record);

    NetaLabel selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(NetaLabel record);

    int updateByPrimaryKey(NetaLabel record);
}