package com.xnqn.netacn.service.impl;

import com.xnqn.netacn.mapper.UserInfoMapper;
import com.xnqn.netacn.model.UserInfo;
import com.xnqn.netacn.service.UserInfoService;
import com.xnqn.netacn.utils.MD5Util;
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
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserAccount(userInfo.getUserAccount());
        userInfo1.setUserPassword(MD5Util.strToMd5(userInfo.getUserPassword()));
        userInfoMapper.insert(userInfo1);
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
        UserInfo userInfo = userInfoMapper.selectByAccount(account);
        userInfo.setUserPassword(null);
        return userInfo;
    }
}
