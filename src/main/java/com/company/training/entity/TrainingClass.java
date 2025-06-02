package com.company.training.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrainingClass {
    private Long id;
    private String className;
    private Integer classStuNum;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}