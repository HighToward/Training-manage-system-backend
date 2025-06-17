package com.company.training.mapper;

import com.company.training.entity.StudentCourseFancy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentCourseFancyMapper {
    
    /**
     * 插入点赞记录
     */
    int insert(StudentCourseFancy fancy);
    
    /**
     * 根据学生ID和课程ID查询点赞记录
     */
    StudentCourseFancy selectByStuIdAndCouId(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 根据学生ID查询点赞的课程列表
     */
    List<Map<String, Object>> selectFanciesByStuId(@Param("stuId") Long stuId);
    
    /**
     * 逻辑删除点赞记录
     */
    int logicalDeleteByStuIdAndCouId(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 检查是否已点赞
     */
    int checkFancyExists(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 获取课程的点赞数量
     */
    int getFancyCountByCouId(@Param("couId") Long couId);
    
    /**
     * 根据学生ID和课程ID查询点赞记录（包括已删除的）
     */
    StudentCourseFancy selectByStuIdAndCouIdIncludeDeleted(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 根据主键更新点赞记录
     */
    int updateByPrimaryKey(StudentCourseFancy fancy);
}