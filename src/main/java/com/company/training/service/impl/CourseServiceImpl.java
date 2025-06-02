package com.company.training.service.impl;

import com.company.training.entity.Course;
import com.company.training.entity.CourseType;
import com.company.training.entity.vo.CourseQueryVO;
import com.company.training.entity.vo.CourseVO;
import com.company.training.mapper.CourseMapper;
import com.company.training.mapper.CourseTypeMapper;
import com.company.training.mapper.TeacherMapper;
import com.company.training.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CourseTypeMapper courseTypeMapper;

    @Override
    public PageInfo<CourseVO> getCourseList(CourseQueryVO queryVO) {
        PageHelper.startPage(queryVO.getPageNum(), queryVO.getPageSize());
        List<Course> courses = courseMapper.selectByCondition(queryVO);

        List<CourseVO> courseVOs = courses.stream().map(course -> {
            CourseVO vo = new CourseVO();
            BeanUtils.copyProperties(course, vo);

            // 设置教师名称
            if (course.getTeaId() != null) {
                vo.setTeaName(teacherMapper.selectByPrimaryKey(course.getTeaId()).getTeaName());
            }

            // 设置类型名称
            if (course.getCouTypeId() != null) {
                vo.setTypeName(courseTypeMapper.selectByPrimaryKey(course.getCouTypeId()).getTypeName());
            }

            if (course.getCouParTypeId() != null) {
                vo.setParentTypeName(courseTypeMapper.selectByPrimaryKey(course.getCouParTypeId()).getTypeName());
            }

            return vo;
        }).collect(Collectors.toList());

        return new PageInfo<>(courseVOs);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public boolean saveCourse(Course course) {
        if (course.getId() == null) {
            return courseMapper.insert(course) > 0;
        } else {
            return courseMapper.updateByPrimaryKey(course) > 0;
        }
    }

    @Override
    @Transactional
    public boolean updateCourse(Course course) {
        return courseMapper.updateByPrimaryKey(course) > 0;
    }

    @Override
    @Transactional
    public boolean deleteCourse(Long id) {
        return courseMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<CourseType> getCourseTypeTree() {
        List<CourseType> parentTypes = courseTypeMapper.selectByParentId(0L);
        parentTypes.forEach(parent -> {
            List<CourseType> children = courseTypeMapper.selectByParentId(parent.getId());
            parent.setChildren(children);
        });
        return parentTypes;
    }

    @Override
    @Transactional
    public boolean updateChapterNum(Long courseId, int num) {
        return courseMapper.updateChapterNum(courseId, num) > 0;
    }

}