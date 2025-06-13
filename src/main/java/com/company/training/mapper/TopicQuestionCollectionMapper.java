package com.company.training.mapper;

import com.company.training.entity.TopicQuestionCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicQuestionCollectionMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(TopicQuestionCollection record);
    
    TopicQuestionCollection selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(TopicQuestionCollection record);
    
    TopicQuestionCollection selectByStuIdAndQId(@Param("stuId") Long stuId, @Param("qId") Long qId);
    
    List<TopicQuestionCollection> selectByStudentId(Long stuId);
    
    List<TopicQuestionCollection> selectByQuestionId(Long qId);
}