package com.company.training.service.impl;

import com.company.training.entity.*;
import com.company.training.mapper.*;
import com.company.training.service.TopicQuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TopicQuestionServiceImpl implements TopicQuestionService {
    
    @Autowired
    private TopicQuestionMapper topicQuestionMapper;
    
    @Autowired
    private TopicQuestionLikeMapper topicQuestionLikeMapper;
    
    @Autowired
    private TopicQuestionCollectionMapper topicQuestionCollectionMapper;
    
    @Value("${file.upload-dir:uploads/img}")
    private String uploadDir;
    
    @Override
    public List<TopicQuestion> getTopicQuestionList() {
        return topicQuestionMapper.selectAll();
    }
    
    @Override
    public TopicQuestion getTopicQuestionById(Long id) {
        return topicQuestionMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<TopicQuestion> getTopicQuestionByStudentId(Long stuId) {
        return topicQuestionMapper.selectByStudentId(stuId);
    }
    
    @Override
    public List<TopicQuestion> getTopicQuestionByClassId(Long classId) {
        return topicQuestionMapper.selectByClassId(classId);
    }
    
    @Override
    @Transactional
    public void createTopicQuestion(TopicQuestion topicQuestion) {
        topicQuestion.setCreateTime(new Date());
        topicQuestion.setUpdateTime(new Date());
        topicQuestion.setDeleted(0);
        topicQuestion.setLikeNum(0);
        topicQuestion.setCollectionNum(0);
        topicQuestion.setHasAdopt(0);
        topicQuestionMapper.insert(topicQuestion);
    }
    
    @Override
    @Transactional
    public void updateTopicQuestion(TopicQuestion topicQuestion) {
        topicQuestion.setUpdateTime(new Date());
        topicQuestionMapper.updateByPrimaryKey(topicQuestion);
    }
    
    @Override
    @Transactional
    public void deleteTopicQuestion(Long id) {
        TopicQuestion topicQuestion = new TopicQuestion();
        topicQuestion.setId(id);
        topicQuestion.setDeleted(1);
        topicQuestion.setUpdateTime(new Date());
        topicQuestionMapper.updateByPrimaryKey(topicQuestion);
    }
    
    @Override
    @Transactional
    public void likeTopicQuestion(Long id, Long stuId) {
        // 检查是否已经点赞
        TopicQuestionLike existingLike = topicQuestionLikeMapper.selectByStuIdAndQId(stuId, id);
        
        if (existingLike == null) {
            // 新增点赞记录
            TopicQuestionLike like = new TopicQuestionLike();
            like.setStuId(stuId);
            like.setQId(id);
            like.setLike(1);
            like.setCreateTime(new Date());
            like.setUpdateTime(new Date());
            topicQuestionLikeMapper.insert(like);
            
            // 更新问题点赞数
            topicQuestionMapper.incrementLikeNum(id);
        } else {
            // 切换点赞状态
            int newLikeStatus = existingLike.getLike() == 1 ? 0 : 1;
            existingLike.setLike(newLikeStatus);
            existingLike.setUpdateTime(new Date());
            topicQuestionLikeMapper.updateByPrimaryKey(existingLike);
            
            // 更新问题点赞数
            if (newLikeStatus == 1) {
                topicQuestionMapper.incrementLikeNum(id);
            } else {
                topicQuestionMapper.decrementLikeNum(id);
            }
        }
    }
    
    @Override
    @Transactional
    public void collectTopicQuestion(Long id, Long stuId) {
        // 检查是否已经收藏
        TopicQuestionCollection existingCollection = topicQuestionCollectionMapper.selectByStuIdAndQId(stuId, id);
        
        if (existingCollection == null) {
            // 新增收藏记录
            TopicQuestionCollection collection = new TopicQuestionCollection();
            collection.setStuId(stuId);
            collection.setQId(id);
            collection.setCollection(1);
            collection.setCreateTime(new Date());
            collection.setUpdateTime(new Date());
            topicQuestionCollectionMapper.insert(collection);
            
            // 更新问题收藏数
            topicQuestionMapper.incrementCollectionNum(id);
        } else {
            // 切换收藏状态
            int newCollectionStatus = existingCollection.getCollection() == 1 ? 0 : 1;
            existingCollection.setCollection(newCollectionStatus);
            existingCollection.setUpdateTime(new Date());
            topicQuestionCollectionMapper.updateByPrimaryKey(existingCollection);
            
            // 更新问题收藏数
            if (newCollectionStatus == 1) {
                topicQuestionMapper.incrementCollectionNum(id);
            } else {
                topicQuestionMapper.decrementCollectionNum(id);
            }
        }
    }
    
    @Override
    public List<String> getQuestionTypes() {
        return topicQuestionMapper.selectDistinctQuestionTypes();
    }
    

    
    @Override
    public List<String> getQuestionImages(Long qId) {
        return topicQuestionMapper.selectImagesByQuestionId(qId);
    }
    
    @Override
    @Transactional
    public void adoptQuestion(Long id) {
        TopicQuestion question = topicQuestionMapper.selectByPrimaryKey(id);
        if (question != null) {
            question.setHasAdopt(1);
            question.setUpdateTime(new Date());
            topicQuestionMapper.updateByPrimaryKey(question);
        }
    }
    
    @Override
    @Transactional
    public void cancelAdoptQuestion(Long id) {
        TopicQuestion question = topicQuestionMapper.selectByPrimaryKey(id);
        if (question != null) {
            question.setHasAdopt(0);
            question.setUpdateTime(new Date());
            topicQuestionMapper.updateByPrimaryKey(question);
        }
    }
    
    @Override
    @Transactional
    public void batchAdoptQuestions(List<Long> ids) {
        for (Long id : ids) {
            adoptQuestion(id);
        }
    }
    
    @Override
    @Transactional
    public void rejectQuestion(Long id) {
        TopicQuestion question = topicQuestionMapper.selectByPrimaryKey(id);
        if (question != null) {
            question.setHasAdopt(2);
            question.setUpdateTime(new Date());
            topicQuestionMapper.updateByPrimaryKey(question);
        }
    }
}