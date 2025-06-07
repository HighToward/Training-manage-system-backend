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
    private String pic;  // 新增头像字段

    // getters and setters
}
