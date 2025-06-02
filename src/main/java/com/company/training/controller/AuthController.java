package com.company.training.controller;

import com.company.training.model.LoginRequest;
import com.company.training.model.LoginResponse;
import com.company.training.model.Result;
import com.company.training.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Result<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse loginResponse = authService.login(loginRequest);
            return ResponseEntity.ok(Result.success(loginResponse));
        } catch (RuntimeException e) {
            // 对于特定的错误信息，如“用户不存在”或“密码错误”，可以返回更具体的HTTP状态码或错误代码
            // 这里统一返回401，前端根据message判断
            if ("用户不存在".equals(e.getMessage()) || "密码错误".equals(e.getMessage())) {
                 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.error(e.getMessage()));
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error("登录失败: " + e.getMessage()));
        }
    }
}