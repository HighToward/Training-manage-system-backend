package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TopicQuestion {
    private Long id;
    private Long stuId;
    private Long teaId;
    private Integer hasAdopt;
    private String content;
    private Integer likeNum;
    private String questionType;
    private Integer collectionNum;
    private Date createTime;
    private Integer deleted;
    private Date updateTime;
    private Long classId;
}