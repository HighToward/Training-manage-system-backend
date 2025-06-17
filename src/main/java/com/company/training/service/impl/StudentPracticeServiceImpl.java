package com.company.training.service.impl;

import com.company.training.entity.StudentPractice;
import com.company.training.mapper.StudentPracticeMapper;
import com.company.training.service.StudentPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentPracticeServiceImpl implements StudentPracticeService {

    @Autowired
    private StudentPracticeMapper studentPracticeMapper;

    @Override
    public List<StudentPractice> getStudentPracticesByPracticeId(Long practiceId) {
        return studentPracticeMapper.selectByPracticeId(practiceId);
    }

    @Override
    public List<StudentPractice> getStudentPracticesByStudentId(Long studentId) {
        return studentPracticeMapper.selectByStudentId(studentId);
    }

    @Override
    @Transactional
    public boolean saveStudentPractice(StudentPractice studentPractice) {
        if (studentPractice.getId() == null) {
            // 新增学生实践关联
            return studentPracticeMapper.insert(studentPractice) > 0;
        } else {
            // 更新学生实践关联
            return studentPracticeMapper.updateByPrimaryKey(studentPractice) > 0;
        }
    }

    @Override
    @Transactional
    public boolean updateStudentPractice(StudentPractice studentPractice) {
        return studentPracticeMapper.updateByPrimaryKey(studentPractice) > 0;
    }

    @Override
    @Transactional
    public boolean deleteStudentPractice(Long id) {
        return studentPracticeMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    @Transactional
    public boolean deleteByStudentAndPractice(Long studentId, Long practiceId) {
        return studentPracticeMapper.deleteByStudentAndPractice(studentId, practiceId) > 0;
    }

    @Override
    public StudentPractice getStudentPracticeByStudentAndPractice(Long studentId, Long practiceId) {
        return studentPracticeMapper.selectByStudentAndPractice(studentId, practiceId);
    }

    @Override
    public boolean isStudentEnrolledInPractice(Long studentId, Long practiceId) {
        StudentPractice studentPractice = studentPracticeMapper.selectByStudentAndPractice(studentId, practiceId);
        return studentPractice != null;
    }
}