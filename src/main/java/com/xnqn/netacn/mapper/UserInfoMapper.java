package com.xnqn.netacn.mapper;

import com.xnqn.netacn.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int deleteByAccount(String  userAccount);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    UserInfo selectByAccount(String  userAccount);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByAccountSelective(UserInfo record);

}