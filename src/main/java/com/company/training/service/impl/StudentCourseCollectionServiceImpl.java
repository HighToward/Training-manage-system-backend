package com.company.training.service.impl;

import com.company.training.entity.StudentCourseCollection;
import com.company.training.entity.vo.Result;
import com.company.training.mapper.StudentCourseCollectionMapper;
import com.company.training.service.StudentCourseCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentCourseCollectionServiceImpl implements StudentCourseCollectionService {
    
    @Autowired
    private StudentCourseCollectionMapper collectionMapper;
    
    @Override
    public Result addCollection(Long stuId, Long couId) {
        try {
            // 检查是否已经收藏（未删除的记录）
            int exists = collectionMapper.checkCollectionExists(stuId, couId);
            if (exists > 0) {
                return Result.error("已经收藏过该课程");
            }
            
            // 检查是否存在已删除的收藏记录
            StudentCourseCollection deletedCollection = collectionMapper.selectByStuIdAndCouIdIncludeDeleted(stuId, couId);
            if (deletedCollection != null && deletedCollection.getDeleted() == 1) {
                // 恢复已删除的记录
                deletedCollection.setDeleted(0);
                deletedCollection.setUpdateTime(java.time.LocalDateTime.now());
                int result = collectionMapper.updateByPrimaryKey(deletedCollection);
                if (result > 0) {
                    return Result.success("收藏成功");
                } else {
                    return Result.error("收藏失败");
                }
            } else {
                // 添加新的收藏记录
                StudentCourseCollection collection = new StudentCourseCollection(stuId, couId);
                int result = collectionMapper.insert(collection);
                
                if (result > 0) {
                    return Result.success("收藏成功");
                } else {
                    return Result.error("收藏失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("收藏失败：" + e.getMessage());
        }
    }
    
    @Override
    public Result removeCollection(Long stuId, Long couId) {
        try {
            int result = collectionMapper.logicalDeleteByStuIdAndCouId(stuId, couId);
            
            if (result > 0) {
                return Result.success("取消收藏成功");
            } else {
                return Result.error("取消收藏失败，未找到收藏记录");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("取消收藏失败：" + e.getMessage());
        }
    }
    
    @Override
    public Result getCollectionsByStuId(Long stuId) {
        try {
            List<Map<String, Object>> collections = collectionMapper.selectCollectionsByStuId(stuId);
            return Result.success(collections);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取收藏列表失败：" + e.getMessage());
        }
    }
    
    @Override
    public Result checkCollectionStatus(Long stuId, Long couId) {
        try {
            int exists = collectionMapper.checkCollectionExists(stuId, couId);
            return Result.success(exists > 0);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("检查收藏状态失败：" + e.getMessage());
        }
    }
    
    @Override
    public Result getCollectionCountByCouId(Long couId) {
        try {
            int count = collectionMapper.getCollectionCountByCouId(couId);
            return Result.success(count);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取收藏数量失败：" + e.getMessage());
        }
    }
}