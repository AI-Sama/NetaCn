package com.xnqn.netacn.service.impl;

import com.xnqn.netacn.mapper.UserInfoMapper;
import com.xnqn.netacn.model.PageInfo;
import com.xnqn.netacn.model.UserInfo;
import com.xnqn.netacn.service.UserInfoService;
import com.xnqn.netacn.utils.MD5Util;
import com.xnqn.netacn.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public int addUser(UserInfo userInfo) {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserAccount(userInfo.getUserAccount());
        //md5加密
        userInfo1.setUserPassword(MD5Util.strToMd5(userInfo.getUserPassword()));
        if (userInfoMapper.selectByAccount(userInfo1.getUserAccount()) != null) {
            //账号已注册
            return 0;
        }
        userInfoMapper.insert(userInfo1);
        return 1;
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        userInfoMapper.deleteByAccount(userInfo.getUserAccount());
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        //更新用户基础信息
        if (userInfoMapper.selectByUserName(userInfo.getUserName()) != null) {
            //昵称已占用
            return 0;
        }
        UserInfo change = new UserInfo();
        change.setUserAccount(userInfo.getUserAccount());
        change.setUserName(userInfo.getUserName());
        change.setWordLimit(userInfo.getWordLimit());
        change.setUserLanguage(userInfo.getUserLanguage());
        if (change.getUserAccount().equals(change.getUserName())) {
            //如果昵称和账号名相同,说明是默认昵称
            change.setUserName(null);
        }
        userInfoMapper.updateByAccountSelective(change);
        return 1;
    }

    @Override
    public UserInfo selectUser(String account) {
        UserInfo userInfo = userInfoMapper.selectByAccount(account);
        userInfo.setUserPassword(null);
        return userInfo;
    }

    @Override
    public PageInfo<List<UserInfo>> selectUsers(PageInfo pageInfo) {
        if (pageInfo.getTotal() == 0) {
            pageInfo.setTotal(userInfoMapper.selectUserTotal());
        }
        List<UserInfo> users = userInfoMapper.selectUsers((pageInfo.getPageNum() - 1) * pageInfo.getPageSize(), pageInfo.getPageSize());
        pageInfo.setData(users);
        return pageInfo;
    }

    @Override
    public UserInfo userLogin(UserInfo userInfo) {

        UserInfo getUser = userInfoMapper.selectByAccount(userInfo.getUserAccount());
        if (getUser != null) {
            if (MD5Util.strToMd5(userInfo.getUserPassword()).equals(getUser.getUserPassword())) {
                //登录成功
                getUser.setUserPassword(null);
                getUser.setSpare1(TokenUtils.getJwtToken(getUser.getUserAccount()));
                return getUser;
            }
        }
        return null;
    }
}
