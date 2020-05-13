package com.example.mybatis.generator.demo.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 配置Druid监控启动Servlet拦截
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {
        // IP白名单
        // (没有配置或者为空，则允许所有访问)
        @WebInitParam(name = "allow", value = "127.0.0.1"),
        // IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name = "deny", value = "192.168.0.11"),
        // 用户名
        @WebInitParam(name = "loginUsername", value = "root"),
        // 密码
        @WebInitParam(name = "loginPassword", value = "eric1988"),
        // 禁用HTML页面上的“Reset All”功能
        @WebInitParam(name = "resetEnable", value = "false")
})
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 1L;
}