package com.company.training.controller;

import com.company.training.service.StudentCourseCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
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
            
            boolean success = cartService.addToCart(stuId, couId);
            
            if (success) {
                result.put("success", true);
                result.put("message", "添加到购物车成功");
                result.put("cartCount", cartService.getCartCount(stuId));
            } else {
                result.put("success", false);
                result.put("message", "添加失败，课程可能已在购物车中或已购买");
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
            Long stuId = Long.valueOf(params.get("stuId").toString());
            @SuppressWarnings("unchecked")
            List<Long> couIds = (List<Long>) params.get("couIds");
            
            return cartService.checkoutCart(stuId, couIds);
            
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "结算失败：" + e.getMessage());
            return result;
        }
    }
}