package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Chapter {
    private Long id;
    private Long couId;
    private Integer chaIndex;
    private String chaTitle;
    private String chaUrl;
    private Date createTime;
    private Integer deleted;
    private Date updateTime;
}