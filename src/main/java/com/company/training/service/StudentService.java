package com.company.training.service;

import com.company.training.entity.Student;
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
}