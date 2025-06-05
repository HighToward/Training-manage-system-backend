package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InformationComments {
    private Long id;
    private Long infoId;
    private Long userId;
    private String content;
    private Long infoLikeNum;
    private Long atId;
    private Long parentCommentsId;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
}