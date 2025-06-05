package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InformationLike {
    private Long id;
    private Long stuId;
    private Long infoId;
    private Date createTime;
    private Integer deleted;
    private Date updateTime;
}