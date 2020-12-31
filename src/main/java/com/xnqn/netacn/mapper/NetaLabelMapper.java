package com.xnqn.netacn.mapper;

import com.xnqn.netacn.model.NetaLabel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NetaLabelMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(@Param("records")List<NetaLabel> records);

    int insertSelective(NetaLabel record);

    NetaLabel selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(NetaLabel record);

    List<NetaLabel> selectLabels();
    List<NetaLabel> selectLabelsByLabelName(@Param("netaLabels") List<NetaLabel> netaLabels);
    List<NetaLabel> fuzzySelectLabels(String labelName);
}