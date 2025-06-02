package com.company.training.entity.vo;

import lombok.Data;

@Data
public class ClassQueryVO {
    private String className;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}