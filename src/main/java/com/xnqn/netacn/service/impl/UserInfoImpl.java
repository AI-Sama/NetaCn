package com.xnqn.netacn.service.impl;

import com.xnqn.netacn.mapper.UserInfoMapper;
import com.xnqn.netacn.model.UserInfo;
import com.xnqn.netacn.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/16 14:48
 * @Description:
 */
@Service
public class UserInfoImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public void addUser(UserInfo userInfo) {
            userInfoMapper.insert(userInfo);
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        userInfoMapper.deleteByAccount(userInfo.getUserAccount());
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userInfoMapper.updateByAccountSelective(userInfo);
    }

    @Override
    public UserInfo selectUser(String account) {
        UserInfo userInfo=userInfoMapper.selectByAccount(account);
        userInfo.setUserPassword(null);
        return userInfo;
    }
}
