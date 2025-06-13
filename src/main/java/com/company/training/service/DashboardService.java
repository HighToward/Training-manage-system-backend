package com.company.training.service;

import java.util.List;
import java.util.Map;

public interface DashboardService {
    
    /**
     * 获取统计数据
     * @return 包含各种统计数据的Map
     */
    Map<String, Object> getStats();
    
    /**
     * 获取最新评论（前5条）
     * @return 最新评论列表
     */
    List<Map<String, Object>> getLatestComments();
    
    /**
     * 获取最新课程（前5条）
     * @return 最新课程列表
     */
    List<Map<String, Object>> getLatestCourses();
    
    /**
     * 获取最新购买记录（前5条）
     * @return 最新购买记录列表
     */
    List<Map<String, Object>> getLatestPurchases();
}