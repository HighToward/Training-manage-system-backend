package com.company.training.service;

import com.company.training.entity.Practice;
import com.company.training.entity.Course;
import java.util.List;

public interface PracticeService {
    List<Practice> getPracticeList(Long courseId);

    boolean savePractice(Practice practice);

    boolean updatePractice(Practice practice);

    boolean deletePractice(Long id);

    boolean batchSavePractices(List<Practice> practices);

    Course getCourseInfo(Long courseId);

    Practice getPracticeById(Long id);

    List<Practice> getAllPractices();

    List<Practice> getPracticesByTeacherId(Long teacherId);
}