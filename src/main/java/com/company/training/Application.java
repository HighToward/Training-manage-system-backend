package com.company.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.company.training.mapper") // 添加MapperScan注解
@EnableTransactionManagement // 启用事务管理
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}