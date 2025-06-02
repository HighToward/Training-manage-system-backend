package com.company.training.entity.vo;

import lombok.Data;

@Data
public class StudentQueryVO {
    private String stuName;
    // Add other filterable fields if needed, e.g., userId
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}