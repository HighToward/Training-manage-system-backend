package com.company.training.service;

import com.company.training.entity.TopicQuestion;

import java.util.List;

public interface TopicQuestionService {
    
    List<TopicQuestion> getTopicQuestionList();
    
    List<TopicQuestion> getTopicQuestionList(Integer pageNum, Integer pageSize);
    
    TopicQuestion getTopicQuestionById(Long id);
    
    List<TopicQuestion> getTopicQuestionByStudentId(Long stuId);
    
    List<TopicQuestion> getTopicQuestionByClassId(Long classId);
    
    void createTopicQuestion(TopicQuestion topicQuestion);
    
    void updateTopicQuestion(TopicQuestion topicQuestion);
    
    void deleteTopicQuestion(Long id);
    
    void likeTopicQuestion(Long id, Long stuId);
    
    void collectTopicQuestion(Long id, Long stuId);
    
    List<String> getQuestionTypes();
    
    List<String> getQuestionImages(Long qId);
    
    // 采纳问题
    void adoptQuestion(Long id);
    
    // 取消采纳问题
    void cancelAdoptQuestion(Long id);
    
    // 批量采纳问题
    void batchAdoptQuestions(List<Long> ids);
    
    // 不采纳问题
    void rejectQuestion(Long id);
}