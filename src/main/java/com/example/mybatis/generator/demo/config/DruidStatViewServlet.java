package com.example.mybatis.generator.demo.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 配置Druid监控启动Servlet拦截,druid数据源状态监控.
 * 要记得在启动类上加上注解：@ServletComponentScan是的spring能够扫描到我们自己编写的servlet和filter
 */
@WebServlet(name = "druidStatViewServlet", urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name = "allow", value = "127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
        @WebInitParam(name = "deny", value = ""),// IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name = "loginUsername", value = "admin"),// 用户名
        @WebInitParam(name = "loginPassword", value = "admin"),// 密码
        @WebInitParam(name = "resetEnable", value = "true")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 2359758657306626394L;
}