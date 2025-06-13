package com.company.training.mapper;

import com.company.training.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper {
    Teacher selectByPrimaryKey(Long id);
    List<Teacher> selectAll();
    
    // 新增方法
    Teacher selectByUserId(@Param("userId") Long userId);
    int updateByPrimaryKey(Teacher teacher);
    
    // 修改这个方法，移除 @Select 注解，改为在 XML 中定义
    Teacher selectTeacherWithAvatar(@Param("id") Long id);
}