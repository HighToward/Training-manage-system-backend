package com.company.training.mapper;

import com.company.training.entity.TopicQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicQuestionMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(TopicQuestion record);
    
    TopicQuestion selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(TopicQuestion record);
    
    List<TopicQuestion> selectAll();
    
    List<TopicQuestion> selectWithPagination(@Param("offset") int offset, @Param("pageSize") int pageSize);
    
    List<TopicQuestion> selectByStudentId(Long stuId);
    
    List<TopicQuestion> selectByClassId(Long classId);
    
    int incrementLikeNum(Long id);
    
    int decrementLikeNum(Long id);
    
    int incrementCollectionNum(Long id);
    
    int decrementCollectionNum(Long id);
    
    List<String> selectDistinctQuestionTypes();
    
    List<String> selectImagesByQuestionId(@Param("qId") Long qId);
}