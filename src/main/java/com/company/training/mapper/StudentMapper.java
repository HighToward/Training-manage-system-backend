package com.company.training.mapper;

import com.company.training.entity.Student;
import com.company.training.entity.vo.StudentQueryVO; // 您可能需要一个查询VO
import java.util.List;

public interface StudentMapper {
    int insert(Student record);
    int updateByPrimaryKey(Student record);
    int logicalDeleteByPrimaryKey(Long id); // 逻辑删除
    Student selectByPrimaryKey(Long id);
    List<Student> selectAllActiveStudents(); // 获取所有未删除的学生，用于班级管理等下拉选择
    List<Student> selectByCondition(StudentQueryVO queryVO); // 用于学生列表的分页和条件查询 (如果需要学生管理模块)
    // Add other necessary methods, e.g., findByUserId, etc.
}