package com.company.training.service.impl;

import com.company.training.entity.StudentCourseFancy;
import com.company.training.entity.vo.Result;
import com.company.training.mapper.StudentCourseFancyMapper;
import com.company.training.service.StudentCourseFancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentCourseFancyServiceImpl implements StudentCourseFancyService {
    
    @Autowired
    private StudentCourseFancyMapper fancyMapper;
    
    @Override
    public Result addFancy(Long stuId, Long couId) {
        try {
            // 检查是否已经点赞（未删除的记录）
            int exists = fancyMapper.checkFancyExists(stuId, couId);
            if (exists > 0) {
                return Result.error("已经点赞过该课程");
            }
            
            // 检查是否存在已删除的点赞记录
            StudentCourseFancy deletedFancy = fancyMapper.selectByStuIdAndCouIdIncludeDeleted(stuId, couId);
            if (deletedFancy != null && deletedFancy.getDeleted() == 1) {
                // 恢复已删除的记录
                deletedFancy.setDeleted(0);
                deletedFancy.setUpdateTime(java.time.LocalDateTime.now());
                int result = fancyMapper.updateByPrimaryKey(deletedFancy);
                if (result > 0) {
                    return Result.success("点赞成功");
                } else {
                    return Result.error("点赞失败");
                }
            } else {
                // 添加新的点赞记录
                StudentCourseFancy fancy = new StudentCourseFancy(stuId, couId);
                int result = fancyMapper.insert(fancy);
                
                if (result > 0) {
                    return Result.success("点赞成功");
                } else {
                    return Result.error("点赞失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("点赞失败：" + e.getMessage());
        }
    }
    
    @Override
    public Result removeFancy(Long stuId, Long couId) {
        try {
            int result = fancyMapper.logicalDeleteByStuIdAndCouId(stuId, couId);
            
            if (result > 0) {
                return Result.success("取消点赞成功");
            } else {
                return Result.error("取消点赞失败，未找到点赞记录");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("取消点赞失败：" + e.getMessage());
        }
    }
    
    @Override
    public Result getFanciesByStuId(Long stuId) {
        try {
            List<Map<String, Object>> fancies = fancyMapper.selectFanciesByStuId(stuId);
            return Result.success(fancies);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取点赞列表失败：" + e.getMessage());
        }
    }
    
    @Override
    public Result checkFancyStatus(Long stuId, Long couId) {
        try {
            int exists = fancyMapper.checkFancyExists(stuId, couId);
            return Result.success(exists > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("检查点赞状态失败：" + e.getMessage());
        }
    }
    
    @Override
    public Result getFancyCountByCouId(Long couId) {
        try {
            int count = fancyMapper.getFancyCountByCouId(couId);
            return Result.success(count);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取点赞数量失败：" + e.getMessage());
        }
    }
}