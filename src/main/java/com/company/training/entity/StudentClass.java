package com.company.training.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StudentClass {
    private Long id;
    private Long stuId;
    private Long classId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}