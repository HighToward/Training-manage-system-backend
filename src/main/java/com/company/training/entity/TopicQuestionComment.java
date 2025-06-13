package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TopicQuestionComment {
    private Long id;
    private Long qId;
    private Long stuId;
    private Integer teaId;
    private String content;
    private Integer hasAdopt;
    private Integer likeNum;
    private Long replyId;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
}