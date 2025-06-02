package com.company.training.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class CourseQueryVO {
    private String couName;
    private List<Long> couTypeIds;
    private Long teaId;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}