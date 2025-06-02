package com.company.training.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CourseClass {
    private Long id;
    private Long couId;
    private Long classId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}