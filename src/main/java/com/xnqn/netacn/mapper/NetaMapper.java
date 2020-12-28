package com.xnqn.netacn.mapper;

import com.xnqn.netacn.model.Neta;

public interface NetaMapper {
    int deleteByPrimaryKey(Integer netaId);

    int insert(Neta record);

    int insertSelective(Neta record);

    Neta selectByPrimaryKey(Integer netaId);

    int updateByPrimaryKeySelective(Neta record);

}