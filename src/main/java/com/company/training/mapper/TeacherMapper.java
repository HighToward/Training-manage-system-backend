package com.company.training.mapper;

import com.company.training.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface TeacherMapper {
    Teacher selectByPrimaryKey(Long id);
    List<Teacher> selectAll();
    
    // 新增方法
    Teacher selectByUserId(@Param("userId") Long userId);
    int updateByPrimaryKey(Teacher teacher);
}