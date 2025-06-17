package com.company.training.service;

import com.company.training.entity.vo.Result;

import java.util.List;
import java.util.Map;

public interface StudentCourseCollectionService {
    
    /**
     * 添加收藏
     */
    Result addCollection(Long stuId, Long couId);
    
    /**
     * 取消收藏
     */
    Result removeCollection(Long stuId, Long couId);
    
    /**
     * 获取学生的收藏列表
     */
    Result getCollectionsByStuId(Long stuId);
    
    /**
     * 检查是否已收藏
     */
    Result checkCollectionStatus(Long stuId, Long couId);
    
    /**
     * 根据课程ID获取收藏数量
     */
    Result getCollectionCountByCouId(Long couId);
}