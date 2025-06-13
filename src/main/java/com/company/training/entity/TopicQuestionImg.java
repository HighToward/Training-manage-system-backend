package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TopicQuestionImg {
    private Long id;
    private Long qId;
    private String url;
    private Integer deleted;
    private Date createTime;
    private Date updateTime;
}