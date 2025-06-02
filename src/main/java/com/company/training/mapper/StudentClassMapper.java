package com.company.training.mapper;

import com.company.training.entity.Student;
import com.company.training.entity.StudentClass;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentClassMapper {
    int insert(StudentClass record);
    int delete(@Param("classId") Long classId, @Param("studentId") Long studentId);
    int deleteByClassId(Long classId); // When a class is deleted
    List<Student> findStudentsByClassId(Long classId);
    // To get students not in this class, you might need a more complex query or handle in service
    // For simplicity, often you fetch all students and filter in frontend/service, or use a NOT IN subquery
    List<StudentClass> findByClassId(Long classId); // Get all student_class entries for a class
}