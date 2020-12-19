package com.xnqn.netacn.utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/19 14:04
 * @Description:Md5加密工具类
 */
public class MD5Util {
    //盐值，用来混肴md5值
    private static final String slat = "7777777";

    public static String strToMd5(String str) {
        //生成md5值
        str = str + slat;
        String result = null;
        try {
            result = DigestUtils.md5DigestAsHex(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
