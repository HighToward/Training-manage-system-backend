package com.company.training.controller;

import com.company.training.entity.Course;
import com.company.training.entity.CourseType;
import com.company.training.entity.vo.CourseQueryVO;
import com.company.training.entity.vo.CourseVO;
import com.company.training.entity.vo.Result;
import com.company.training.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public Result<PageInfo<CourseVO>> getCourseList(CourseQueryVO queryVO) {
        PageInfo<CourseVO> pageInfo = courseService.getCourseList(queryVO);
        return Result.success(pageInfo);
    }

    @GetMapping("/{id}")
    public Result<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return Result.success(course);
    }

    @PostMapping
    public Result<Boolean> saveCourse(@RequestBody Course course) {
        boolean success = courseService.saveCourse(course);
        return success ? Result.success(true) : Result.error("保存失败");
    }

    @PutMapping
    public Result<Boolean> updateCourse(@RequestBody Course course) {
        boolean success = courseService.updateCourse(course);
        return success ? Result.success(true) : Result.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteCourse(@PathVariable Long id) {
        boolean success = courseService.deleteCourse(id);
        return success ? Result.success(true) : Result.error("删除失败");
    }

    @GetMapping("/types")
    public Result<List<CourseType>> getCourseTypeTree() {
        List<CourseType> typeTree = courseService.getCourseTypeTree();
        return Result.success(typeTree);
    }
}