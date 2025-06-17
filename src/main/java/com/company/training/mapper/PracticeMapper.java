package com.company.training.mapper;

import com.company.training.entity.Practice;
import java.util.List;

public interface PracticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Practice record);

    Practice selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Practice record);

    List<Practice> selectByCourseId(Long courseId);

    int deleteByCourseId(Long courseId);

    List<Practice> selectAll();

    List<Practice> selectByTeacherId(Long teacherId);
}