package com.company.training.controller;

import com.company.training.entity.StudentOrder;
import com.company.training.entity.StudentOrderDetail;
import com.company.training.mapper.StudentOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student/order")
public class StudentOrderController {
    
    @Autowired
    private StudentOrderMapper orderMapper;
    
    /**
     * 获取学生订单列表
     */
    @GetMapping("/list/{stuId}")
    public Map<String, Object> getOrderList(@PathVariable Long stuId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            List<StudentOrder> orders = orderMapper.selectOrdersByStuId(stuId);
            
            result.put("success", true);
            result.put("data", orders);
            result.put("count", orders.size());
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "获取订单列表失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 获取订单详情（包含订单信息和课程详情）
     */
    @GetMapping("/detail/{orderId}")
    public Map<String, Object> getOrderDetail(@PathVariable Long orderId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            StudentOrder order = orderMapper.selectByOrderId(orderId);
            if (order == null) {
                result.put("success", false);
                result.put("message", "订单不存在");
                return result;
            }
            
            List<StudentOrderDetail> orderDetails = orderMapper.selectOrderDetailsByOrderId(orderId);
            
            Map<String, Object> orderData = new HashMap<>();
            orderData.put("order", order);
            orderData.put("details", orderDetails);
            
            result.put("success", true);
            result.put("data", orderData);
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "获取订单详情失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 获取订单列表（包含订单概要信息）
     */
    @GetMapping("/list-with-summary/{stuId}")
    public Map<String, Object> getOrderListWithSummary(@PathVariable Long stuId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            List<Map<String, Object>> orders = orderMapper.selectOrderWithDetailsByStuId(stuId);
            
            result.put("success", true);
            result.put("data", orders);
            result.put("count", orders.size());
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "获取订单列表失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 获取学生已购买的课程列表
     */
    @GetMapping("/purchased-courses/{stuId}")
    public Map<String, Object> getPurchasedCourses(@PathVariable Long stuId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            List<StudentOrderDetail> purchasedCourses = orderMapper.selectPurchasedCoursesByStuId(stuId);
            
            result.put("success", true);
            result.put("data", purchasedCourses);
            result.put("count", purchasedCourses.size());
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "获取已购买课程失败：" + e.getMessage());
        }
        
        return result;
    }
}