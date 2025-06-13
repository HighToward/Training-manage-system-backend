package com.company.training.service.impl;

import com.company.training.mapper.DashboardMapper;
import com.company.training.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {
    
    @Autowired
    private DashboardMapper dashboardMapper;
    
    @Override
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        
        // 获取各项统计数据
        Long informationCount = dashboardMapper.getInformationCount();
        Long courseCount = dashboardMapper.getCourseCount();
        Long commentCount = dashboardMapper.getCommentCount();
        Long studentCount = dashboardMapper.getStudentCount();
        
        stats.put("informationCount", informationCount != null ? informationCount : 0L);
        stats.put("courseCount", courseCount != null ? courseCount : 0L);
        stats.put("commentCount", commentCount != null ? commentCount : 0L);
        stats.put("studentCount", studentCount != null ? studentCount : 0L);
        
        return stats;
    }
    
    @Override
    public List<Map<String, Object>> getLatestComments() {
        return dashboardMapper.getLatestComments(5);
    }
    
    @Override
    public List<Map<String, Object>> getLatestCourses() {
        return dashboardMapper.getLatestCourses(5);
    }
    
    @Override
    public List<Map<String, Object>> getLatestPurchases() {
        return dashboardMapper.getLatestPurchases(5);
    }
}