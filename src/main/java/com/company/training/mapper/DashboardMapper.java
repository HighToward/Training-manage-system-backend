package com.company.training.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DashboardMapper {
    
    /**
     * 获取资讯文章总数
     * @return 资讯文章总数
     */
    Long getInformationCount();
    
    /**
     * 获取课程总数
     * @return 课程总数
     */
    Long getCourseCount();
    
    /**
     * 获取评论总数
     * @return 评论总数
     */
    Long getCommentCount();
    
    /**
     * 获取学生总数
     * @return 学生总数
     */
    Long getStudentCount();
    
    /**
     * 获取最新评论（前5条）
     * @param limit 限制条数
     * @return 最新评论列表
     */
    List<Map<String, Object>> getLatestComments(@Param("limit") int limit);
    
    /**
     * 获取最新课程（前5条）
     * @param limit 限制条数
     * @return 最新课程列表
     */
    List<Map<String, Object>> getLatestCourses(@Param("limit") int limit);
    
    /**
     * 获取最新购买记录（前5条）
     * @param limit 限制条数
     * @return 最新购买记录列表
     */
    List<Map<String, Object>> getLatestPurchases(@Param("limit") int limit);
}