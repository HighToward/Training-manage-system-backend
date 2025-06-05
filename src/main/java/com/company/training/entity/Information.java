package com.company.training.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Information {
    private Long id;
    private Long teaId;
    private String infoTitle;
    private String infoMain;
    private Long infoLike;
    private Long infoCollection;
    private Long infoComment;
    private String infoImage;
    private Date createTime;
    private Integer deleted;
    private Date updateTime;
}