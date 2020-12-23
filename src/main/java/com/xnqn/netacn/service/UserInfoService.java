package com.xnqn.netacn.service;

import com.xnqn.netacn.model.UserInfo;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/15 16:32
 * @Description:
 */
public interface UserInfoService {
    int addUser(UserInfo userInfo);
    void deleteUser(UserInfo userInfo);
    void updateUser(UserInfo userInfo);
    UserInfo selectUser(String account);
    UserInfo userLogin(UserInfo userInfo);
}
