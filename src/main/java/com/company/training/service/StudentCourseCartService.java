package com.company.training.service;

import com.company.training.entity.StudentCourseCart;

import java.util.List;
import java.util.Map;

public interface StudentCourseCartService {
    
    /**
     * 添加课程到购物车
     * @param stuId 学生ID
     * @param couId 课程ID
     * @return 操作结果
     */
    boolean addToCart(Long stuId, Long couId);
    
    /**
     * 添加课程到购物车并返回详细信息
     * @param stuId 学生ID
     * @param couId 课程ID
     * @return 包含操作结果和课程信息的Map
     */
    Map<String, Object> addToCartWithDetails(Long stuId, Long couId);
    
    /**
     * 从购物车移除课程
     * @param stuId 学生ID
     * @param couId 课程ID
     * @return 操作结果
     */
    boolean removeFromCart(Long stuId, Long couId);
    
    /**
     * 批量从购物车移除课程
     * @param stuId 学生ID
     * @param couIds 课程ID列表
     * @return 操作结果
     */
    boolean removeBatchFromCart(Long stuId, List<Long> couIds);
    
    /**
     * 清空购物车
     * @param stuId 学生ID
     * @return 操作结果
     */
    boolean clearCart(Long stuId);
    
    /**
     * 检查课程是否在购物车中
     * @param stuId 学生ID
     * @param couId 课程ID
     * @return 是否在购物车中
     */
    boolean isInCart(Long stuId, Long couId);
    
    /**
     * 获取购物车列表（包含课程详细信息）
     * @param stuId 学生ID
     * @return 购物车列表
     */
    List<Map<String, Object>> getCartList(Long stuId);
    
    /**
     * 获取购物车中课程数量
     * @param stuId 学生ID
     * @return 课程数量
     */
    int getCartCount(Long stuId);
    
    /**
     * 购物车结算（批量购买）
     * @param stuId 学生ID
     * @param couIds 要购买的课程ID列表
     * @return 操作结果
     */
    Map<String, Object> checkoutCart(Long stuId, List<Long> couIds);
}