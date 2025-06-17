package com.company.training.service.impl;

import com.company.training.entity.Practice;
import com.company.training.entity.Course;
import com.company.training.mapper.PracticeMapper;
import com.company.training.service.PracticeService;
import com.company.training.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {

    @Autowired
    private PracticeMapper practiceMapper;

    @Autowired
    private CourseService courseService;

    @Override
    public List<Practice> getPracticeList(Long courseId) {
        return practiceMapper.selectByCourseId(courseId);
    }

    @Override
    public List<Practice> getAllPractices() {
        return practiceMapper.selectAll();
    }

    @Override
    public List<Practice> getPracticesByTeacherId(Long teacherId) {
        return practiceMapper.selectByTeacherId(teacherId);
    }

    @Override
    public Course getCourseInfo(Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @Override
    @Transactional
    public boolean savePractice(Practice practice) {
        if (practice.getId() == null) {
            // 新增实践时，从课程中获取tea_id
            if (practice.getCouId() != null && practice.getTeaId() == null) {
                Course course = courseService.getCourseById(practice.getCouId());
                if (course != null && course.getTeaId() != null) {
                    practice.setTeaId(course.getTeaId());
                }
            }
            return practiceMapper.insert(practice) > 0;
        } else {
            // 更新实践
            return practiceMapper.updateByPrimaryKey(practice) > 0;
        }
    }

    @Override
    @Transactional
    public boolean updatePractice(Practice practice) {
        return practiceMapper.updateByPrimaryKey(practice) > 0;
    }

    @Override
    @Transactional
    public boolean deletePractice(Long id) {
        return practiceMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    @Transactional
    public boolean batchSavePractices(List<Practice> practices) {
        if (practices == null || practices.isEmpty()) {
            return false;
        }

        // 先删除原有实践
        Long courseId = practices.get(0).getCouId();
        practiceMapper.deleteByCourseId(courseId);

        // 获取课程信息以获取tea_id
        Course course = courseService.getCourseById(courseId);
        Long teaId = course != null ? course.getTeaId() : null;

        // 批量插入新实践
        practices.forEach(practice -> {
            practice.setId(null); // 确保新增
            if (practice.getTeaId() == null && teaId != null) {
                practice.setTeaId(teaId); // 设置tea_id
            }
            practiceMapper.insert(practice);
        });

        return true;
    }

    @Override
    public Practice getPracticeById(Long id) {
        return practiceMapper.selectByPrimaryKey(id);
    }
}