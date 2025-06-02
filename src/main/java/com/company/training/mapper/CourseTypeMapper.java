package com.company.training.mapper;

import com.company.training.entity.CourseType;
import java.util.List;

public interface CourseTypeMapper {
    List<CourseType> selectAll();

    List<CourseType> selectByParentId(Long parentId);

    CourseType selectByPrimaryKey(Long id);
}