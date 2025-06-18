package com.company.training.controller;

import com.company.training.service.StudentCourseCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class StudentCourseCartController {
    
    @Autowired
    private StudentCourseCartService cartService;
    
    /**
     * 添加课程到购物车
     */
    @PostMapping("/add")
    public Map<String, Object> addToCart(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            Long stuId = Long.valueOf(params.get("stuId").toString());
            Long couId = Long.valueOf(params.get("couId").toString());
            
            Map<String, Object> addResult = cartService.addToCartWithDetails(stuId, couId);
            
            if ((Boolean) addResult.get("success")) {
                result.put("success", true);
                result.put("message", "添加到购物车成功");
                result.put("cartCount", cartService.getCartCount(stuId));
                result.put("courseInfo", addResult.get("courseInfo"));
            } else {
                result.put("success", false);
                result.put("message", addResult.get("message"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "添加到购物车失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 从购物车移除课程
     */
    @DeleteMapping("/remove")
    public Map<String, Object> removeFromCart(@RequestParam Long stuId, @RequestParam Long couId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            boolean success = cartService.removeFromCart(stuId, couId);
            
            if (success) {
                result.put("success", true);
                result.put("message", "移除成功");
                result.put("cartCount", cartService.getCartCount(stuId));
            } else {
                result.put("success", false);
                result.put("message", "移除失败");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "移除失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 批量从购物车移除课程
     */
    @DeleteMapping("/remove-batch")
    public Map<String, Object> removeBatchFromCart(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            Long stuId = Long.valueOf(params.get("stuId").toString());
            @SuppressWarnings("unchecked")
            List<Long> couIds = (List<Long>) params.get("couIds");
            
            boolean success = cartService.removeBatchFromCart(stuId, couIds);
            
            if (success) {
                result.put("success", true);
                result.put("message", "批量移除成功");
                result.put("cartCount", cartService.getCartCount(stuId));
            } else {
                result.put("success", false);
                result.put("message", "批量移除失败");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "批量移除失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 清空购物车
     */
    @DeleteMapping("/clear")
    public Map<String, Object> clearCart(@RequestParam Long stuId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            boolean success = cartService.clearCart(stuId);
            
            result.put("success", true);
            result.put("message", "清空购物车成功");
            result.put("cartCount", 0);
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "清空购物车失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 检查课程是否在购物车中
     */
    @GetMapping("/check")
    public Map<String, Object> checkInCart(@RequestParam Long stuId, @RequestParam Long couId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            boolean inCart = cartService.isInCart(stuId, couId);
            
            result.put("success", true);
            result.put("inCart", inCart);
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "检查失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 获取购物车列表
     */
    @GetMapping("/list")
    public Map<String, Object> getCartList(@RequestParam Long stuId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            List<Map<String, Object>> cartList = cartService.getCartList(stuId);
            
            result.put("success", true);
            result.put("data", cartList);
            result.put("count", cartList.size());
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "获取购物车列表失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 获取购物车中课程数量
     */
    @GetMapping("/count")
    public Map<String, Object> getCartCount(@RequestParam Long stuId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            int count = cartService.getCartCount(stuId);
            
            result.put("success", true);
            result.put("count", count);
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "获取购物车数量失败：" + e.getMessage());
        }
        
        return result;
    }
    
    /**
     * 购物车结算（批量购买）
     */
    @PostMapping("/checkout")
    public Map<String, Object> checkoutCart(@RequestBody Map<String, Object> params) {
        try {
            System.out.println("=== 购物车结算请求参数 ===");
            System.out.println("接收到的参数: " + params);
            
            Long stuId = Long.valueOf(params.get("stuId").toString());
            System.out.println("学生ID: " + stuId);
            
            // 安全地解析couIds，处理不同的数据类型
            @SuppressWarnings("unchecked")
            List<Object> couIdsObj = (List<Object>) params.get("couIds");
            List<Long> couIds = new ArrayList<>();
            if (couIdsObj != null) {
                for (Object obj : couIdsObj) {
                    if (obj instanceof Number) {
                        couIds.add(((Number) obj).longValue());
                    } else {
                        couIds.add(Long.valueOf(obj.toString()));
                    }
                }
            }
            System.out.println("课程ID列表: " + couIds);
            
            Map<String, Object> result = cartService.checkoutCart(stuId, couIds);
            System.out.println("结算结果: " + result);
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "结算失败：" + e.getMessage());
            return result;
        }
    }
}