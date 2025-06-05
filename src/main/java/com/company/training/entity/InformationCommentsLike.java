package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InformationCommentsLike {
    private Long id;
    private Long stuId;
    private Long infoComId;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
}