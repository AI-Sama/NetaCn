package com.xnqn.netacn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: netacn
 * @Author: ZhangXiangQiang
 * @Create: 2020/12/14 15:42
 * @Description: web配置
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器路径
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //添加虚拟路径
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域
        registry.addMapping("/**") //配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径
                .allowedMethods("*") //允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等
                .allowedHeaders("*") //允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
                .allowedOrigins("*"); //允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
    }
}
