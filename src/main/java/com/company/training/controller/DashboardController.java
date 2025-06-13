package com.company.training.controller;

import com.company.training.entity.vo.Result;
import com.company.training.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {
    
    @Autowired
    private DashboardService dashboardService;
    
    // 获取统计数据
    @GetMapping("/stats")
    public Result<Map<String, Object>> getStats() {
        try {
            Map<String, Object> stats = dashboardService.getStats();
            return Result.success(stats);
        } catch (Exception e) {
            return Result.error("获取统计数据失败: " + e.getMessage());
        }
    }
    
    // 获取最新评论
    @GetMapping("/latest-comments")
    public Result<List<Map<String, Object>>> getLatestComments() {
        try {
            List<Map<String, Object>> comments = dashboardService.getLatestComments();
            return Result.success(comments);
        } catch (Exception e) {
            return Result.error("获取最新评论失败: " + e.getMessage());
        }
    }
    
    // 获取最新课程
    @GetMapping("/latest-courses")
    public Result<List<Map<String, Object>>> getLatestCourses() {
        try {
            List<Map<String, Object>> courses = dashboardService.getLatestCourses();
            return Result.success(courses);
        } catch (Exception e) {
            return Result.error("获取最新课程失败: " + e.getMessage());
        }
    }
    
    // 获取最新购买记录
    @GetMapping("/latest-purchases")
    public Result<List<Map<String, Object>>> getLatestPurchases() {
        try {
            List<Map<String, Object>> purchases = dashboardService.getLatestPurchases();
            return Result.success(purchases);
        } catch (Exception e) {
            return Result.error("获取最新购买记录失败: " + e.getMessage());
        }
    }
}