package com.company.training.service.impl;

import com.company.training.entity.Teacher;
import com.company.training.mapper.TeacherMapper;
import com.company.training.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.selectAll();
    }
}