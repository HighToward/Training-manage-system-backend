package com.company.training.entity;

import lombok.Data;
import java.time.LocalDateTime; // SQL DDL uses timestamp, mapping to LocalDateTime

@Data
public class Student {
    private Long id;           // bigint NOT NULL COMMENT '学生ID'
    private Long userId;       // bigint NOT NULL COMMENT '用户ID(逻辑外键)'
    private String stuName;    // varchar(20) NOT NULL COMMENT '学生姓名(默认用户名)'
    private Long stuStudyTime; // bigint NOT NULL DEFAULT 0 COMMENT '总学习时长(单位:分钟)'
    private Long stuScore;     // bigint NULL DEFAULT 100 COMMENT '学生积分'
    private String clock;      // varchar(100) NOT NULL DEFAULT '0000000' COMMENT '打卡记录(7位字符串)'
    private LocalDateTime createTime; // timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
    private Integer deleted;    // int NOT NULL DEFAULT 0
    private LocalDateTime updateTime; // timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
}