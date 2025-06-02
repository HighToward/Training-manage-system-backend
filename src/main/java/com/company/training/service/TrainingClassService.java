package com.company.training.service;

import com.company.training.entity.Student;
import com.company.training.entity.TrainingClass;
import com.company.training.entity.vo.ClassQueryVO;
import com.github.pagehelper.PageInfo;
import com.company.training.entity.vo.CourseVO;
import java.util.List;

public interface TrainingClassService {
    // Class Info Management
    boolean saveClass(TrainingClass trainingClass);
    boolean updateClass(TrainingClass trainingClass);
    boolean deleteClass(Long id); // Logical delete
    TrainingClass getClassById(Long id);
    PageInfo<TrainingClass> getClassList(ClassQueryVO queryVO);
    List<TrainingClass> getAllClasses();


    // Class Student Management
    List<Student> getStudentsByClassId(Long classId);
    List<Student> getAvailableStudentsForClass(Long classId); // Students not in this class
    boolean addStudentToClass(Long classId, Long studentId);
    boolean removeStudentFromClass(Long classId, Long studentId);

    // Class Course Management
    List<CourseVO> getCoursesByClassId(Long classId); // <--- 修改返回类型
    List<CourseVO> getAvailableCoursesForClass(Long classId); // <--- 修改返回类型
    boolean addCourseToClass(Long classId, Long courseId);
    boolean removeCourseFromClass(Long classId, Long courseId);
}