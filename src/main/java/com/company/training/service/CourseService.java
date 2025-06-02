package com.company.training.service;

import com.company.training.entity.Course;
import com.company.training.entity.CourseType;
import com.company.training.entity.vo.CourseQueryVO;
import com.company.training.entity.vo.CourseVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseService {
    PageInfo<CourseVO> getCourseList(CourseQueryVO queryVO);

    Course getCourseById(Long id);

    boolean saveCourse(Course course);

    boolean updateCourse(Course course);

    boolean deleteCourse(Long id);

    List<CourseType> getCourseTypeTree();

    boolean updateChapterNum(Long courseId, int num);
}