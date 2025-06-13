package com.company.training.service.impl;

import com.company.training.entity.StudentCourseAppraise;
import com.company.training.mapper.StudentCourseAppraiseMapper;
import com.company.training.service.StudentCourseAppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentCourseAppraiseServiceImpl implements StudentCourseAppraiseService {

    @Autowired
    private StudentCourseAppraiseMapper studentCourseAppraiseMapper;

    @Override
    public boolean saveAppraise(StudentCourseAppraise appraise) {
        try {
            appraise.setCreateTime(LocalDateTime.now());
            appraise.setUpdateTime(LocalDateTime.now());
            appraise.setDeleted(0);
            return studentCourseAppraiseMapper.insert(appraise) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAppraise(StudentCourseAppraise appraise) {
        try {
            appraise.setUpdateTime(LocalDateTime.now());
            return studentCourseAppraiseMapper.updateByPrimaryKey(appraise) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAppraise(Long id) {
        try {
            return studentCourseAppraiseMapper.logicalDeleteByPrimaryKey(id) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public StudentCourseAppraise getAppraiseById(Long id) {
        return studentCourseAppraiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StudentCourseAppraise> getAppraisesByCourseId(Long couId) {
        return studentCourseAppraiseMapper.selectByCourseId(couId);
    }

    @Override
    public StudentCourseAppraise getAppraiseByStudentAndCourse(Long stuId, Long couId) {
        return studentCourseAppraiseMapper.selectByStudentAndCourse(stuId, couId);
    }

    @Override
    public List<StudentCourseAppraise> getAppraisesByStudentId(Long stuId) {
        return studentCourseAppraiseMapper.selectByStudentId(stuId);
    }

    @Override
    public Map<String, Object> getCourseAppraiseStatistics(Long couId) {
        Map<String, Object> statistics = new HashMap<>();
        
        // 获取平均评分
        Double averageScore = studentCourseAppraiseMapper.selectAverageScoreByCourseId(couId);
        statistics.put("averageScore", averageScore != null ? Math.round(averageScore * 10.0) / 10.0 : 0.0);
        
        // 获取评价总数
        Integer totalCount = studentCourseAppraiseMapper.selectTotalCountByCourseId(couId);
        statistics.put("totalCount", totalCount != null ? totalCount : 0);
        
        // 获取评价列表
        List<StudentCourseAppraise> appraises = studentCourseAppraiseMapper.selectByCourseId(couId);
        statistics.put("appraises", appraises);
        
        return statistics;
    }
}