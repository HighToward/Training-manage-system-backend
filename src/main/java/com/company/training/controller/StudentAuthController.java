package com.company.training.controller;

import com.company.training.entity.Student;
import com.company.training.model.LoginRequest;
import com.company.training.model.LoginResponse;
import com.company.training.service.AuthService;
import com.company.training.service.StudentService;
import com.company.training.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentAuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            LoginResponse loginResponse = authService.studentLogin(loginRequest);
            
            response.put("success", true);
            response.put("message", "登录成功");
            response.put("token", loginResponse.getToken());
            response.put("user", loginResponse.getUserInfo());
            
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getStudentProfile(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("code", 401, "message", "未提供有效的认证令牌"));
            }
            
            Long userId = jwtUtil.parseUserId(token.replace("Bearer ", ""));
            Student student = studentService.getStudentByUserId(userId);
            
            if (student == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("code", 404, "message", "学生信息未找到"));
            }
            
            // 统一返回格式
            return ResponseEntity.ok(Map.of("code", 200, "data", student, "message", "获取成功"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("code", 500, "message", "获取学生信息失败: " + e.getMessage()));
        }
    }
    
    @PostMapping("/checkin")
    public ResponseEntity<?> studentCheckin(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("code", 401, "message", "未提供有效的认证令牌"));
            }
            
            Long userId = jwtUtil.parseUserId(token.replace("Bearer ", ""));
            Student student = studentService.getStudentByUserId(userId);
            
            if (student == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("code", 404, "message", "学生信息未找到"));
            }
            
            // 执行签到逻辑
            boolean success = studentService.performCheckin(student.getId());
            
            if (success) {
                return ResponseEntity.ok(Map.of("code", 200, "message", "签到成功！获得10积分", "success", true));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("code", 400, "message", "今日已签到", "success", false));
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("code", 500, "message", "签到失败: " + e.getMessage()));
        }
    }
}