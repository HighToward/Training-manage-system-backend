package com.company.training.controller;

import com.company.training.entity.Teacher;
import com.company.training.entity.vo.Result;
import com.company.training.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public Result<List<Teacher>> getTeacherList() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return Result.success(teachers);
    }
}