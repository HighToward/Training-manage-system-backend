package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TopicQuestionCollection {
    private Long id;
    private Long stuId;
    private Long qId;
    private Integer collection;
    private Date createTime;
    private Date updateTime;
}