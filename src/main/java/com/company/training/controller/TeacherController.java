package com.company.training.controller;

import com.company.training.entity.Teacher;
import com.company.training.entity.vo.Result;
import com.company.training.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public Result<List<Teacher>> getTeacherList() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return Result.success(teachers);
    }
    
    // 新增：获取当前用户信息
    @GetMapping("/current")
    public Result<Map<String, Object>> getCurrentUserInfo(@RequestHeader("Authorization") String token) {
        try {
            Map<String, Object> userInfo = teacherService.getCurrentUserInfo(token);
            return Result.success(userInfo);
        } catch (Exception e) {
            return Result.error("获取用户信息失败: " + e.getMessage());
        }
    }
    
    // 新增：更新个人信息
    @PutMapping("/profile")
    public Result<String> updateProfile(@RequestHeader("Authorization") String token, 
                                       @RequestBody Map<String, Object> profileData) {
        try {
            teacherService.updateProfile(token, profileData);
            return Result.success("更新成功");
        } catch (Exception e) {
            return Result.error("更新失败: " + e.getMessage());
        }
    }
}