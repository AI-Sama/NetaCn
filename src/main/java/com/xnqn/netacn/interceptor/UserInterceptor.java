package com.xnqn.netacn.interceptor;

import com.xnqn.netacn.utils.TokenUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/24 18:42
 * @Description: 用户拦截器
 */
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if("OPTIONS".equals(request.getMethod().toUpperCase())) {
//              放行OPTIONS请求
//            return true;
//        }
        String token = request.getHeader("token");
        if (token == null || token.trim().length() <= 0) {
            // 重定向
            response.sendRedirect("/error/errorToken");
            return false;
        }
        String userAccount = TokenUtils.verifyToken(token);
        if (userAccount != null) {
            request.setAttribute("userAccount", userAccount);
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
