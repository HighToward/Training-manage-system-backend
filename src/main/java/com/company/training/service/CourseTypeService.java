package com.company.training.service;

import com.company.training.entity.CourseType;
import java.util.List;

public interface CourseTypeService {
    List<CourseType> getCourseTypeTree();
    List<CourseType> getChildrenByParentId(Long parentId);
    CourseType getTypeById(Long id);
}