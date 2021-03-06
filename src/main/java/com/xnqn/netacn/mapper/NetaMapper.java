package com.xnqn.netacn.mapper;

import com.xnqn.netacn.model.Neta;
import com.xnqn.netacn.model.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    int selectCountNetas(Integer pb);
    List<Neta>  selectNetas(PageInfo pageInfo);
    int changeNetaStatus(@Param("netas") List<Neta> netas,@Param("netaStatus")Integer netaStatus,@Param("reason")String reason);
}