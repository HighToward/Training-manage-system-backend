package com.company.training.service;

import com.company.training.entity.TopicQuestion;

import java.util.List;

public interface TopicQuestionService {
    
    List<TopicQuestion> getTopicQuestionList();
    
    TopicQuestion getTopicQuestionById(Long id);
    
    List<TopicQuestion> getTopicQuestionByStudentId(Long stuId);
    
    List<TopicQuestion> getTopicQuestionByClassId(Long classId);
    
    void createTopicQuestion(TopicQuestion topicQuestion);
    
    void updateTopicQuestion(TopicQuestion topicQuestion);
    
    void deleteTopicQuestion(Long id);
    
    void likeTopicQuestion(Long id, Long stuId);
    
    void collectTopicQuestion(Long id, Long stuId);
    
    List<String> getQuestionTypes();
}