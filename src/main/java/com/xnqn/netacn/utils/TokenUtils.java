package com.xnqn.netacn.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/23 16:46
 * @Description:Token 工具类
 */

@Component
@Data
public class TokenUtils {
    //过期时间/天
    private static long EXPIRE;
    //密钥
    private static String APP_SECRET;

    public long getEXPIRE() {
        return EXPIRE;
    }

    @Value("${data.expire}")
    public void setEXPIRE(long EXPIRE) {
        TokenUtils.EXPIRE = EXPIRE;
    }

    public String getAppSecret() {
        return APP_SECRET;
    }

    @Value("${data.secret}")
    public void setAppSecret(String appSecret) {
        APP_SECRET = appSecret;
    }

    public static String getJwtToken(String userAccount) {
        //生成token
        String jwtToken = JWT.create()
                .withAudience("user") //签发对象
                .withIssuedAt(new Date())//签发时间
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE * 1000 * 60 * 60 * 24))//过期时间
                .withClaim("userAccount", userAccount)//自定义参数
                .sign(Algorithm.HMAC256(APP_SECRET));//加入密钥以及加密方式
        return jwtToken;
    }

    public static String verifyToken(String token) {
        //解析token，返回账号
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(APP_SECRET)).build();
        DecodedJWT decodedJWT;
        try {
            decodedJWT = verifier.verify(token);
        } catch (Exception e) {
            //验证失败,过期|不匹配
            return null;
        }
        return decodedJWT.getClaim("userAccount").asString();
    }
}
