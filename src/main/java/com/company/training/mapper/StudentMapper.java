package com.company.training.mapper;

import com.company.training.entity.Student;
import com.company.training.entity.vo.StudentQueryVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentMapper {
    int insert(Student record);
    int updateByPrimaryKey(Student record);
    int logicalDeleteByPrimaryKey(Long id);
    Student selectByPrimaryKey(Long id);
    List<Student> selectAllActiveStudents();
    List<Student> selectByCondition(StudentQueryVO queryVO);
    // 新增方法：根据用户ID查询学生信息
    Student findByUserId(@Param("userId") Long userId);
}