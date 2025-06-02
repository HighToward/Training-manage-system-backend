package com.company.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String welcome() {
        return "后端项目已启动成功，请访问API或前端页面，查看是否正常";
    }
}