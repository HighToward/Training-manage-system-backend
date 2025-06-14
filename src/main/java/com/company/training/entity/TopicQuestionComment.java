package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TopicQuestionComment {
    private Long id;
    private Long qId;
    private Long stuId;
    private Long teaId;
    private String content;
    private Integer hasAdopt;
    private Integer likeNum;
    private Long atId;  // 被@用户ID(0表示未@)
    private Long parentCommentsId;  // 父评论ID(0表示一级评论)
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
    
    // 用户信息字段（非数据库字段）
    private String userName;  // 用户名
    private String userAvatar;  // 用户头像
    private String userType;  // 用户类型（student/teacher）
    
    // 前端兼容字段（用于统一用户ID处理）
    private Long userId;  // 统一用户ID字段（非数据库字段）
    
    // userId字段的getter和setter，用于前端兼容
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
        // 注意：这里不自动设置stuId/teaId，需要在服务层根据用户类型处理
    }
}