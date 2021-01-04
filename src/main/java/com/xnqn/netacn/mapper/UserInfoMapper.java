package com.xnqn.netacn.mapper;

import com.xnqn.netacn.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int deleteByAccount(String  userAccount);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    UserInfo selectByAccount(String  userAccount);

    UserInfo selectByUserName(String  userName);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByAccountSelective(UserInfo record);
    int selectUserTotal();
    List<UserInfo> selectUsers(@Param("pageNum") Integer pageNum, @Param("pageSize")Integer pageSize);
}