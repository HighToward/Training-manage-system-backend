package com.company.training.mapper;

import com.company.training.entity.TrainingClass; // 假设已重命名
import com.company.training.entity.vo.ClassQueryVO; // 新建查询VO
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TrainingClassMapper {
    int insert(TrainingClass record);
    int updateByPrimaryKey(TrainingClass record);
    int deleteByPrimaryKey(Long id); // 逻辑删除
    TrainingClass selectByPrimaryKey(Long id);
    List<TrainingClass> selectByCondition(ClassQueryVO queryVO); // 条件查询和列表
    List<TrainingClass> selectAll();
    int logicalDeleteByPrimaryKey(Long id);
    int updateStudentCount(@Param("classId") Long classId, @Param("countChange") int countChange); // 更新班级人数
}