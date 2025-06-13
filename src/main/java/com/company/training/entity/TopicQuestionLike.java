package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TopicQuestionLike {
    private Long id;
    private Long stuId;
    private Long qId;
    private Integer like;
    private Date createTime;
    private Date updateTime;
}