package com.company.training.service;

import com.company.training.entity.StudentCourseAppraise;
import java.util.List;
import java.util.Map;

public interface StudentCourseAppraiseService {
    boolean saveAppraise(StudentCourseAppraise appraise);
    boolean updateAppraise(StudentCourseAppraise appraise);
    boolean deleteAppraise(Long id);
    StudentCourseAppraise getAppraiseById(Long id);
    List<StudentCourseAppraise> getAppraisesByCourseId(Long couId);
    StudentCourseAppraise getAppraiseByStudentAndCourse(Long stuId, Long couId);
    List<StudentCourseAppraise> getAppraisesByStudentId(Long stuId);
    Map<String, Object> getCourseAppraiseStatistics(Long couId);
}