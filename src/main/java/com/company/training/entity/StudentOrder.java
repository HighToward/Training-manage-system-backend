package com.company.training.entity;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class StudentOrder {
    private Long id;
    private String code;
    private Long stuId;
    private Long amount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;
    
}