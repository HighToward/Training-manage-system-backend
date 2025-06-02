package com.company.training.mapper;

import com.company.training.entity.Course;
import com.company.training.entity.vo.CourseQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Course record);

    List<Course> selectByCondition(CourseQueryVO queryVO);

    int countByCondition(CourseQueryVO queryVO);

    int updateChapterNum(@Param("courseId") Long courseId,
                         @Param("num") int num);

}