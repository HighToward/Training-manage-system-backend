package com.company.training.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class CourseType {
    private Long id;
    private Long parentTypeId;
    private String typeName;
    private Date createTime;
    private Integer deleted;
    private Date updateTime;

    private List<CourseType> children;
}