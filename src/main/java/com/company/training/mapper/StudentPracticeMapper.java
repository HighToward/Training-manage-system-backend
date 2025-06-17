package com.company.training.mapper;

import com.company.training.entity.StudentPractice;
import java.util.List;

public interface StudentPracticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudentPractice record);

    StudentPractice selectByPrimaryKey(Long id);

    int updateByPrimaryKey(StudentPractice record);

    List<StudentPractice> selectByPracticeId(Long practiceId);

    List<StudentPractice> selectByStudentId(Long studentId);

    int deleteByPracticeId(Long practiceId);

    int deleteByStudentAndPractice(Long studentId, Long practiceId);

    StudentPractice selectByStudentAndPractice(Long studentId, Long practiceId);
}