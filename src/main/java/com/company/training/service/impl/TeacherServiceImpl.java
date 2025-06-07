package com.company.training.service.impl;

import com.company.training.entity.Teacher;
import com.company.training.entity.User;
import com.company.training.mapper.TeacherMapper;
import com.company.training.mapper.UserMapper;
import com.company.training.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.training.util.JwtUtil;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.selectAll();
    }
    
    @Override
    public Map<String, Object> getCurrentUserInfo(String token) {
        Long userId = parseUserIdFromToken(token);
        
        // 根据用户ID查询用户信息
        User user = userMapper.findById(userId);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        
        // 根据用户ID查询教师信息（通过user_id字段关联）
        Teacher teacher = teacherMapper.selectByUserId(userId);
        if (teacher == null) {
            throw new RuntimeException("教师信息不存在");
        }
        
        Map<String, Object> result = new HashMap<>();
        result.put("id", teacher.getId());
        result.put("username", user.getUsername());  // 用户表的用户名作为"账号"
        result.put("teaName", teacher.getTeaName()); // 教师表的教师姓名
        result.put("pic", user.getPic());            // 用户表的头像
        result.put("coursNum", teacher.getCoursNum());
        result.put("role", user.getRole()); 
        // 不再返回createTime
        
        return result;
    }
    
    @Override
    public void updateProfile(String token, Map<String, Object> profileData) {
        Long userId = parseUserIdFromToken(token);
        
        // 更新用户表的头像
        if (profileData.containsKey("pic")) {
            User user = new User();
            user.setId(userId);
            user.setPic((String) profileData.get("pic"));
            userMapper.updateUserProfile(user);
        }
        
        // 更新教师表的姓名
        if (profileData.containsKey("teaName")) {
            Teacher teacher = teacherMapper.selectByUserId(userId);
            if (teacher != null) {
                teacher.setTeaName((String) profileData.get("teaName"));
                teacherMapper.updateByPrimaryKey(teacher);
            }
        }
    }
    
    // 简化的token解析方法
    private Long parseUserIdFromToken(String token) {
        try {
            // 使用注入的jwtUtil实例
            return jwtUtil.parseUserId(token);
        } catch (Exception e) {
            throw new RuntimeException("Token解析失败: " + e.getMessage());
        }
    }
}