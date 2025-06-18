package com.company.training.service.impl;

import com.company.training.entity.Student;
import com.company.training.entity.StudentCourseCart;
import com.company.training.entity.StudentOrder;
import com.company.training.entity.StudentOrderDetail;
import com.company.training.mapper.CourseMapper;
import com.company.training.mapper.StudentCourseCartMapper;
import com.company.training.mapper.StudentMapper;
import com.company.training.mapper.StudentOrderMapper;
import com.company.training.service.StudentCourseCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class StudentCourseCartServiceImpl implements StudentCourseCartService {
    
    @Autowired
    private StudentCourseCartMapper cartMapper;
    
    @Autowired
    private StudentOrderMapper orderMapper;
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Autowired
    private CourseMapper courseMapper;
    
    @Override
    public boolean addToCart(Long stuId, Long couId) {
        try {
            // 检查是否已在购物车中
            if (isInCart(stuId, couId)) {
                return false; // 已在购物车中
            }
            
            // 检查是否已购买
            if (orderMapper.selectOrderDetailByStuIdAndCourseId(stuId, couId) != null) {
                return false; // 已购买，不能加入购物车
            }
            
            StudentCourseCart cart = new StudentCourseCart(stuId, couId);
            cart.setCreateTime(LocalDateTime.now());
            cart.setUpdateTime(LocalDateTime.now());
            cart.setDeleted(0);
            
            return cartMapper.insert(cart) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Map<String, Object> addToCartWithDetails(Long stuId, Long couId) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            // 检查是否已在购物车中
            if (isInCart(stuId, couId)) {
                result.put("success", false);
                result.put("message", "课程已在购物车中");
                return result;
            }
            
            // 检查是否已购买
            if (orderMapper.selectOrderDetailByStuIdAndCourseId(stuId, couId) != null) {
                result.put("success", false);
                result.put("message", "课程已购买");
                return result;
            }
            
            // 获取课程信息
            Map<String, Object> courseInfo = courseMapper.selectCourseById(couId);
            if (courseInfo == null) {
                result.put("success", false);
                result.put("message", "课程不存在");
                return result;
            }
            
            StudentCourseCart cart = new StudentCourseCart(stuId, couId);
            cart.setCreateTime(LocalDateTime.now());
            cart.setUpdateTime(LocalDateTime.now());
            cart.setDeleted(0);
            
            if (cartMapper.insert(cart) > 0) {
                result.put("success", true);
                result.put("message", "添加到购物车成功");
                result.put("courseInfo", courseInfo);
            } else {
                result.put("success", false);
                result.put("message", "添加到购物车失败");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "添加到购物车失败：" + e.getMessage());
        }
        
        return result;
    }
    
    @Override
    public boolean removeFromCart(Long stuId, Long couId) {
        try {
            return cartMapper.deleteByStudentAndCourse(stuId, couId) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean removeBatchFromCart(Long stuId, List<Long> couIds) {
        try {
            if (couIds == null || couIds.isEmpty()) {
                return false;
            }
            return cartMapper.deleteBatchByStudentAndCourses(stuId, couIds) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean clearCart(Long stuId) {
        try {
            return cartMapper.deleteAllByStudent(stuId) >= 0; // 即使没有数据也算成功
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean isInCart(Long stuId, Long couId) {
        try {
            return cartMapper.selectByStudentAndCourse(stuId, couId) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Map<String, Object>> getCartList(Long stuId) {
        try {
            return cartMapper.selectCartWithCourseInfo(stuId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    @Override
    public int getCartCount(Long stuId) {
        try {
            return cartMapper.countByStudent(stuId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    @Override
    @Transactional
    public Map<String, Object> checkoutCart(Long stuId, List<Long> couIds) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            System.out.println("=== 购物车结算服务开始 ===");
            System.out.println("学生ID: " + stuId);
            System.out.println("要购买的课程ID列表: " + couIds);
            
            if (couIds == null || couIds.isEmpty()) {
                result.put("success", false);
                result.put("message", "请选择要购买的课程");
                return result;
            }
            
            // 获取购物车中的课程信息
            List<Map<String, Object>> cartItems = getCartList(stuId);
            System.out.println("购物车中的课程数量: " + cartItems.size());
            System.out.println("购物车详细信息: " + cartItems);
            
            List<Map<String, Object>> selectedItems = new ArrayList<>();
            long totalAmount = 0;
            
            for (Map<String, Object> item : cartItems) {
                Object couIdObj = item.get("couId");
                Long couId = null;
                if (couIdObj instanceof Number) {
                    couId = ((Number) couIdObj).longValue();
                } else if (couIdObj != null) {
                    couId = Long.valueOf(couIdObj.toString());
                }
                
                System.out.println("检查购物车项目 - 课程ID: " + couId + ", 是否在选择列表中: " + couIds.contains(couId));
                
                if (couId != null && couIds.contains(couId)) {
                    selectedItems.add(item);
                    Object priceObj = item.get("couPrice");
                    Long price = 0L;
                    if (priceObj instanceof Number) {
                        price = ((Number) priceObj).longValue();
                    } else if (priceObj != null) {
                        price = Long.valueOf(priceObj.toString());
                    }
                    // 价格转换为积分：1元 = 10积分
                    Long pointsRequired = price * 10;
                    totalAmount += pointsRequired;
                    System.out.println("添加到选中项目: " + item.get("couName") + ", 价格: " + price + "元, 需要积分: " + pointsRequired);
                }
            }
            
            System.out.println("选中的课程数量: " + selectedItems.size());
            System.out.println("总需要积分: " + totalAmount);
            
            if (selectedItems.isEmpty()) {
                result.put("success", false);
                result.put("message", "选择的课程不在购物车中");
                return result;
            }
            
            // 检查学生积分是否足够
            Student student = studentMapper.selectByPrimaryKey(stuId);
            if (student == null) {
                result.put("success", false);
                result.put("message", "学生信息不存在");
                return result;
            }
            
            Long currentPoints = student.getStuScore();
            if (currentPoints == null || currentPoints < totalAmount) {
                result.put("success", false);
                result.put("message", "积分不足，无法购买。需要积分: " + totalAmount + ", 当前积分: " + (currentPoints != null ? currentPoints : 0));
                return result;
            }
            
            // 创建订单
            StudentOrder order = new StudentOrder();
            order.setCode("ORDER_" + System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 8));
            order.setStuId(stuId);
            order.setAmount(totalAmount);
            order.setCreateTime(LocalDateTime.now());
            order.setUpdateTime(LocalDateTime.now());
            order.setDeleted(0);
            
            int orderResult = orderMapper.insert(order);
            if (orderResult <= 0) {
                result.put("success", false);
                result.put("message", "创建订单失败");
                return result;
            }
            
            // 创建订单详情
            for (Map<String, Object> item : selectedItems) {
                StudentOrderDetail orderDetail = new StudentOrderDetail();
                orderDetail.setOrderId(order.getId());
                orderDetail.setCouId((Long) item.get("couId"));
                orderDetail.setCouPrice((Long) item.get("couPrice"));
                orderDetail.setCouName((String) item.get("couName"));
                orderDetail.setTeaName((String) item.get("teaName"));
                orderDetail.setCouPic((String) item.get("couPic"));
                orderDetail.setCreateTime(LocalDateTime.now());
                orderDetail.setUpdateTime(LocalDateTime.now());
                orderDetail.setDeleted(0);
                
                int detailResult = orderMapper.insertOrderDetail(orderDetail);
                if (detailResult <= 0) {
                    throw new RuntimeException("创建订单详情失败");
                }
            }
            
            // 扣除积分
            long newPoints = currentPoints - totalAmount;
            student.setStuScore(newPoints);
            student.setUpdateTime(LocalDateTime.now());
            int updateResult = studentMapper.updateByPrimaryKey(student);
            if (updateResult <= 0) {
                throw new RuntimeException("扣除积分失败");
            }
            
            // 从购物车中移除已购买的课程
            removeBatchFromCart(stuId, couIds);
            
            result.put("success", true);
            result.put("message", "购买成功");
            result.put("orderId", order.getId());
            result.put("orderCode", order.getCode());
            result.put("totalPoints", totalAmount);
            result.put("remainingPoints", newPoints);
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "购买失败：" + e.getMessage());
        }
        
        return result;
    }
}