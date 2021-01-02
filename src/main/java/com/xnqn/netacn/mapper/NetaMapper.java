package com.xnqn.netacn.mapper;

import com.xnqn.netacn.model.Neta;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NetaMapper {
    int deleteByPrimaryKey(Integer netaId);

    int insert(Neta record);

    int insertSelective(Neta record);

    Neta selectByPrimaryKey(Integer netaId);

    int updateByPrimaryKeySelective(Neta record);

    List<Neta> selectByStatusCode(Integer netaStatus);

}