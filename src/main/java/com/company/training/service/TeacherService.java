package com.company.training.service;

import com.company.training.entity.Teacher;
import java.util.List;
import java.util.Map;

// 在TeacherService接口中添加方法
public interface TeacherService {
    List<Teacher> getAllTeachers();
    
    // 新增方法
    Map<String, Object> getCurrentUserInfo(String token);
    void updateProfile(String token, Map<String, Object> profileData);
    
    /**
     * 根据ID获取教师信息
     * @param id 教师ID
     * @return 教师信息
     */
    Teacher getTeacherById(Long id);
}