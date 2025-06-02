package com.company.training.mapper;

import com.company.training.entity.Teacher;
import java.util.List;

public interface TeacherMapper {
    Teacher selectByPrimaryKey(Long id);
    List<Teacher> selectAll();
}