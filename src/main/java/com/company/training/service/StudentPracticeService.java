package com.company.training.service;

import com.company.training.entity.StudentPractice;
import java.util.List;

public interface StudentPracticeService {
    List<StudentPractice> getStudentPracticesByPracticeId(Long practiceId);

    List<StudentPractice> getStudentPracticesByStudentId(Long studentId);

    boolean saveStudentPractice(StudentPractice studentPractice);

    boolean updateStudentPractice(StudentPractice studentPractice);

    boolean deleteStudentPractice(Long id);

    boolean deleteByStudentAndPractice(Long studentId, Long practiceId);

    StudentPractice getStudentPracticeByStudentAndPractice(Long studentId, Long practiceId);

    boolean isStudentEnrolledInPractice(Long studentId, Long practiceId);
}