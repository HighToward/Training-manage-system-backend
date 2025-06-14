package com.company.training.service;

import com.company.training.entity.TopicQuestionComment;
import com.company.training.entity.Student;
import com.company.training.entity.Teacher;
import com.company.training.mapper.TopicQuestionCommentMapper;
import com.company.training.mapper.StudentMapper;
import com.company.training.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TopicQuestionCommentService {

    @Autowired
    private TopicQuestionCommentMapper topicQuestionCommentMapper;
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Autowired
    private TeacherMapper teacherMapper;

    // 根据问题ID获取评论列表
    public List<TopicQuestionComment> getCommentsByQuestionId(Long qId) {
        return topicQuestionCommentMapper.getCommentsWithUserInfoByQuestionId(qId);
    }
    
    // 根据问题ID获取带用户信息的评论列表
    public List<TopicQuestionComment> getCommentsWithUserInfoByQuestionId(Long qId) {
        return topicQuestionCommentMapper.getCommentsWithUserInfoByQuestionId(qId);
    }

    // 创建评论
    public void createComment(TopicQuestionComment comment) {
        // 如果前端传入了userId，需要根据用户类型设置stuId或teaId
        if (comment.getUserId() != null) {
            // 先查找是否为学生
            Student student = studentMapper.findByUserId(comment.getUserId());
            if (student != null) {
                comment.setStuId(student.getId());
                comment.setTeaId(null);
            } else {
                // 如果不是学生，查找是否为教师
                Teacher teacher = teacherMapper.selectByUserId(comment.getUserId());
                if (teacher != null) {
                    comment.setTeaId(teacher.getId());
                    comment.setStuId(null);
                }
            }
        }
        
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        comment.setDeleted(0);
        comment.setHasAdopt(0);
        comment.setLikeNum(0);
        
        // 设置默认值以避免 NOT NULL 约束错误
        // 注意：如果前端传了具体值（非null），则保持原值；只有null时才设为0
        if (comment.getAtId() == null) {
            comment.setAtId(0L); // 0表示未@任何人
        }
        if (comment.getParentCommentsId() == null) {
            comment.setParentCommentsId(0L); // 0表示一级评论
        }
        
        topicQuestionCommentMapper.insertComment(comment);
    }

    // 删除评论
    public void deleteComment(Long commentId) {
        topicQuestionCommentMapper.deleteComment(commentId);
    }

    // 点赞评论
    public void likeComment(Long commentId) {
        topicQuestionCommentMapper.likeComment(commentId);
    }

    // 取消点赞评论
    public void unlikeComment(Long commentId) {
        topicQuestionCommentMapper.unlikeComment(commentId);
    }

    // 采纳评论
    public void adoptComment(Long commentId) {
        topicQuestionCommentMapper.adoptComment(commentId);
    }
    
    // 根据评论ID获取带用户信息的评论
    public TopicQuestionComment getCommentWithUserInfoById(Long commentId) {
        return topicQuestionCommentMapper.getCommentWithUserInfoById(commentId);
    }
    
    // 根据父评论ID获取回复列表
    public List<TopicQuestionComment> getRepliesByParentId(Long parentId) {
        return topicQuestionCommentMapper.getRepliesByParentId(parentId);
    }
}