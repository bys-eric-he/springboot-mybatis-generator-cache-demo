package com.example.mybatis.generator.demo.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Druid监控过滤器配置规则
 * 要记得在启动类上加上注解：@ServletComponentScan是的spring能够扫描到我们自己编写的servlet和filter
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),//忽略资源
        @WebInitParam(name = "profileEnable", value = "true"),
        @WebInitParam(name = "sessionStatEnable", value = "true"),
        @WebInitParam(name = "principalCookieName", value = "USER_COOKIE"),//启动COOKIE监控
        @WebInitParam(name = "principalSessionName", value = "USER_SESSION") //启动SESSION监控
})
public class DruidStatFilter extends WebStatFilter {

}