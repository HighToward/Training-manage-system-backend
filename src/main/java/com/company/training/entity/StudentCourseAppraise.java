package com.company.training.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StudentCourseAppraise {
    private Long id;                    // bigint NOT NULL COMMENT '评价ID'
    private Long stuId;                 // bigint NOT NULL COMMENT '学生ID'
    private Long couId;                 // bigint NOT NULL COMMENT '课程ID'
    private String couAppraise;         // varchar(500) NULL COMMENT '课程评价内容'
    private Integer evaluateScore;      // int NULL COMMENT '评价分数(1-5分)'
    private LocalDateTime createTime;   // timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
    private Integer deleted;            // int NOT NULL DEFAULT 0
    private LocalDateTime updateTime;   // timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
}