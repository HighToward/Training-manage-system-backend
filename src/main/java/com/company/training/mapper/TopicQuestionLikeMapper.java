package com.company.training.mapper;

import com.company.training.entity.TopicQuestionLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicQuestionLikeMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(TopicQuestionLike record);
    
    TopicQuestionLike selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(TopicQuestionLike record);
    
    TopicQuestionLike selectByStuIdAndQId(@Param("stuId") Long stuId, @Param("qId") Long qId);
    
    List<TopicQuestionLike> selectByStudentId(Long stuId);
    
    List<TopicQuestionLike> selectByQuestionId(Long qId);
}