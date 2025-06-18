package com.company.training.mapper;

import com.company.training.entity.Student;
import com.company.training.entity.StudentClass;
import com.company.training.entity.TrainingClass;
import com.company.training.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface StudentClassMapper {
    int insert(StudentClass record);
    int deleteByPrimaryKey(Long id);
    StudentClass selectByPrimaryKey(Long id);
    List<StudentClass> selectAll();
    int updateByPrimaryKey(StudentClass record);
    
    // 根据班级ID查找学生
    List<StudentClass> findByClassId(@Param("classId") Long classId);
    
    // 根据班级ID查找学生详细信息
    List<Student> findStudentsByClassId(@Param("classId") Long classId);
    
    // 删除学生班级关联
    int deleteByStudentIdAndClassId(@Param("stuId") Long stuId, @Param("classId") Long classId);
    
    // 删除学生班级关联（兼容旧方法）
    int delete(@Param("classId") Long classId, @Param("studentId") Long studentId);
    
    // 根据学生ID查找班级列表
    List<TrainingClass> findClassesByStudentId(@Param("studentId") Long studentId);
    
    // 根据学生ID查找班级课程列表
    List<Course> findClassCoursesByStudentId(@Param("studentId") Long studentId);
    void deleteByClassId(Long id);
}