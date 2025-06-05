package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InformationCollection {
    private Long id;
    private Long stuId;
    private Long infoId;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
}