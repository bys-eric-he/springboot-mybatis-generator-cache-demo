package com.example.mybatis.generator.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.example.mybatis.generator.demo.dao")
/*扫描 @WebServlet @WebFilter @WebListener*/
@ServletComponentScan
public class ComExampleMybatisGeneratorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComExampleMybatisGeneratorDemoApplication.class, args);
    }

}
