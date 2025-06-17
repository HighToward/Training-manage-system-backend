package com.company.training.mapper;

import com.company.training.entity.StudentOrder;
import com.company.training.entity.StudentOrderDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentOrderMapper {
    // 插入订单
    int insert(StudentOrder record);
    
    // 根据学生ID和课程ID查询订单详情
    StudentOrderDetail selectOrderDetailByStuIdAndCourseId(@Param("stuId") Long stuId, @Param("courseId") Long courseId);
    
    // 根据学生ID获取所有购买的课程
    List<StudentOrderDetail> selectPurchasedCoursesByStuId(@Param("stuId") Long stuId);
    
    // 插入订单详情
    int insertOrderDetail(StudentOrderDetail record);
    
    // 根据订单ID查询订单
    StudentOrder selectByOrderId(@Param("orderId") Long orderId);
    
    // 根据学生ID查询订单列表
    List<StudentOrder> selectOrdersByStuId(@Param("stuId") Long stuId);
    
    // 根据订单ID查询订单详情列表
    List<StudentOrderDetail> selectOrderDetailsByOrderId(@Param("orderId") Long orderId);
    
    // 获取订单及其详情信息
    List<java.util.Map<String, Object>> selectOrderWithDetailsByStuId(@Param("stuId") Long stuId);
}