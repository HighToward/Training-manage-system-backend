package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StudentPractice {
    private Long id;
    private Long stuId;
    private Long praId;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
}