package com.xnqn.netacn.mapper;

import com.xnqn.netacn.model.NetaLabel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NetaLabelMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(NetaLabel record);

    int insertSelective(NetaLabel record);

    NetaLabel selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(NetaLabel record);

    List<NetaLabel> selectLabels();
}