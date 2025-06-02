package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data

public class Teacher {
    private Long id;
    private Long userId;
    private String teaName;
    private Integer coursNum;
    private Date createTime;
    private Integer deleted;
    private Date updateTime;

    // getters and setters
}
