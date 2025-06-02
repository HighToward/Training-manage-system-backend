package com.company.training.mapper;

import com.company.training.entity.CourseClass;
import com.company.training.entity.vo.CourseVO; // <--- 引入 CourseVO
// import com.company.training.entity.Course; // 如果其他方法返回 Course，可以保留
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CourseClassMapper {
    int insert(CourseClass record);
    int deleteByClassIdAndCourseId(@Param("classId") Long classId, @Param("courseId") Long courseId);
    int deleteByClassId(Long classId);
    List<CourseVO> getCoursesByClassId(Long classId); // <--- 修改返回类型为 List<CourseVO>
    // 如果 getAvailableCoursesForClass 也需要显示教师名，它也应该返回 List<CourseVO>
    List<CourseVO> getAvailableCoursesForClass(Long classId); // <--- 建议修改
}