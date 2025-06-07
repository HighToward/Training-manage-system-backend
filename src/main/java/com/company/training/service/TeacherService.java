package com.company.training.service;

import com.company.training.entity.Teacher;
import java.util.List;
import java.util.Map;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    
    // 新增方法
    Map<String, Object> getCurrentUserInfo(String token);
    void updateProfile(String token, Map<String, Object> profileData);
}