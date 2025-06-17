package com.company.training.service;

import com.company.training.entity.vo.Result;

import java.util.List;
import java.util.Map;

public interface StudentCourseFancyService {
    
    /**
     * 添加点赞
     */
    Result addFancy(Long stuId, Long couId);
    
    /**
     * 取消点赞
     */
    Result removeFancy(Long stuId, Long couId);
    
    /**
     * 获取学生的点赞列表
     */
    Result getFanciesByStuId(Long stuId);
    
    /**
     * 检查是否已点赞
     */
    Result checkFancyStatus(Long stuId, Long couId);
    
    /**
     * 获取课程的点赞数量
     */
    Result getFancyCountByCouId(Long couId);
}