package com.company.training.mapper;

import com.company.training.entity.StudentCourseCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentCourseCartMapper {
    
    /**
     * 添加课程到购物车
     */
    int insert(StudentCourseCart cart);
    
    /**
     * 从购物车移除课程
     */
    int deleteByStudentAndCourse(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 批量从购物车移除课程
     */
    int deleteBatchByStudentAndCourses(@Param("stuId") Long stuId, @Param("couIds") List<Long> couIds);
    
    /**
     * 清空学生购物车
     */
    int deleteAllByStudent(@Param("stuId") Long stuId);
    
    /**
     * 检查课程是否在购物车中
     */
    StudentCourseCart selectByStudentAndCourse(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 获取学生购物车列表（包含课程详细信息）
     */
    List<Map<String, Object>> selectCartWithCourseInfo(@Param("stuId") Long stuId);
    
    /**
     * 获取购物车中课程数量
     */
    int countByStudent(@Param("stuId") Long stuId);
}