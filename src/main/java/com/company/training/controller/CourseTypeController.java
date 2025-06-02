package com.company.training.controller;

import com.company.training.entity.CourseType;
import com.company.training.entity.vo.Result;
import com.company.training.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-type")
public class CourseTypeController {

    @Autowired
    private CourseTypeService courseTypeService;

    /**
     * 获取所有课程类型（树形结构）
     */
    @GetMapping("/tree")
    public Result<List<CourseType>> getCourseTypeTree() {
        List<CourseType> typeTree = courseTypeService.getCourseTypeTree();
        return Result.success(typeTree);
    }

    /**
     * 根据父类型ID获取子类型列表
     */
    @GetMapping("/children/{parentId}")
    public Result<List<CourseType>> getChildrenByParentId(@PathVariable Long parentId) {
        List<CourseType> children = courseTypeService.getChildrenByParentId(parentId);
        return Result.success(children);
    }

    /**
     * 根据ID获取类型详情
     */
    @GetMapping("/{id}")
    public Result<CourseType> getTypeById(@PathVariable Long id) {
        CourseType courseType = courseTypeService.getTypeById(id);
        return Result.success(courseType);
    }
}