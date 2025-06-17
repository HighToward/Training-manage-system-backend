package com.company.training.mapper;

import com.company.training.entity.StudentCourseCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentCourseCollectionMapper {
    
    /**
     * 插入收藏记录
     */
    int insert(StudentCourseCollection collection);
    
    /**
     * 根据学生ID和课程ID查询收藏记录
     */
    StudentCourseCollection selectByStuIdAndCouId(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 根据学生ID查询收藏的课程列表
     */
    List<Map<String, Object>> selectCollectionsByStuId(@Param("stuId") Long stuId);
    
    /**
     * 逻辑删除收藏记录
     */
    int logicalDeleteByStuIdAndCouId(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 检查是否已收藏
     */
    int checkCollectionExists(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 根据学生ID和课程ID查询收藏记录（包括已删除的）
     */
    StudentCourseCollection selectByStuIdAndCouIdIncludeDeleted(@Param("stuId") Long stuId, @Param("couId") Long couId);
    
    /**
     * 根据主键更新收藏记录
     */
    int updateByPrimaryKey(StudentCourseCollection collection);
    
    /**
     * 根据课程ID获取收藏数量
     */
    int getCollectionCountByCouId(@Param("couId") Long couId);
}