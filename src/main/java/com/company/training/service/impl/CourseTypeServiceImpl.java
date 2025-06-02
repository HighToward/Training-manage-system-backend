package com.company.training.service.impl;

import com.company.training.entity.CourseType;
import com.company.training.mapper.CourseTypeMapper;
import com.company.training.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;

    @Override
    public List<CourseType> getCourseTypeTree() {
        // 获取所有父类型 (parent_type_id = 0)
        List<CourseType> parentTypes = courseTypeMapper.selectByParentId(0L);

        // 为每个父类型设置子类型
        parentTypes.forEach(parent -> {
            List<CourseType> children = courseTypeMapper.selectByParentId(parent.getId());
            parent.setChildren(children);
        });

        return parentTypes;
    }

    @Override
    public List<CourseType> getChildrenByParentId(Long parentId) {
        return courseTypeMapper.selectByParentId(parentId);
    }

    @Override
    public CourseType getTypeById(Long id) {
        return courseTypeMapper.selectByPrimaryKey(id);
    }
}