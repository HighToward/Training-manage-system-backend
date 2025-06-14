package com.company.training.mapper;

import com.company.training.entity.TopicQuestionComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopicQuestionCommentMapper {

    // 根据问题ID获取评论列表
    List<TopicQuestionComment> getCommentsByQuestionId(@Param("qId") Long qId);
    
    // 根据问题ID获取带用户信息的评论列表
    List<TopicQuestionComment> getCommentsWithUserInfoByQuestionId(@Param("qId") Long qId);

    // 插入评论
    void insertComment(TopicQuestionComment comment);

    // 删除评论（软删除）
    void deleteComment(@Param("commentId") Long commentId);

    // 点赞评论
    void likeComment(@Param("commentId") Long commentId);

    // 取消点赞评论
    void unlikeComment(@Param("commentId") Long commentId);

    // 采纳评论
    void adoptComment(@Param("commentId") Long commentId);
    
    // 根据评论ID获取带用户信息的评论
    TopicQuestionComment getCommentWithUserInfoById(@Param("commentId") Long commentId);
    
    // 根据父评论ID获取回复列表
    List<TopicQuestionComment> getRepliesByParentId(@Param("parentId") Long parentId);
}