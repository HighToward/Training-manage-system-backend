package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Practice {
    private Long id;
    private Long teaId;
    private Long couId;
    private String praName;
    private String praSite;
    private String praMain;
    private Date startTime;
    private Date endTime;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
}