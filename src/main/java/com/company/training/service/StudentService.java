package com.company.training.service;

import com.company.training.entity.Student;
import com.company.training.entity.StudentOrderDetail;
import com.company.training.entity.vo.StudentQueryVO;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface StudentService {
    List<Student> getAllActiveStudents();
    PageInfo<Student> getStudentList(StudentQueryVO queryVO);
    boolean saveStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Long id);
    Student getStudentById(Long id);
    // 新增：根据用户ID获取学生信息
    Student getStudentByUserId(Long userId);
    
    // 购买相关方法
    boolean checkCoursePurchased(Long stuId, Long courseId);
    boolean purchaseCourse(Long stuId, Long courseId, Long coursePrice, String courseName, String teacherName, String coursePic);
    List<StudentOrderDetail> getPurchasedCourses(Long stuId);
}