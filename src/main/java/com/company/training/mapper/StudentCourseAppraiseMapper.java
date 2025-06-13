package com.company.training.mapper;

import com.company.training.entity.StudentCourseAppraise;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentCourseAppraiseMapper {
    int insert(StudentCourseAppraise record);
    int updateByPrimaryKey(StudentCourseAppraise record);
    int logicalDeleteByPrimaryKey(Long id);
    StudentCourseAppraise selectByPrimaryKey(Long id);
    List<StudentCourseAppraise> selectByCourseId(@Param("couId") Long couId);
    StudentCourseAppraise selectByStudentAndCourse(@Param("stuId") Long stuId, @Param("couId") Long couId);
    List<StudentCourseAppraise> selectByStudentId(@Param("stuId") Long stuId);
    Double selectAverageScoreByCourseId(@Param("couId") Long couId);
    Integer selectTotalCountByCourseId(@Param("couId") Long couId);
}