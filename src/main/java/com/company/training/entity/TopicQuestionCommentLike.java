package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TopicQuestionCommentLike {
    private Long id;
    private Long stuId;
    private Long cId;
    private Integer like;
    private Date createTime;
    private Date updateTime;
}