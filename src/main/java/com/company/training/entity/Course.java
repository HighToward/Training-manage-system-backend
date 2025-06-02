package com.company.training.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Course {
    private Long id;
    private Long teaId;
    private String couName;
    private String couIntroduction;
    private String couPic;
    private Long couTypeId;
    private Long couParTypeId;
    private BigDecimal couPrice; // 单位：元
    private Integer couCataNum;
    private Long couCollNum;
    private Long couLikeNum;
    private Long couShareNum;
    private Long clicks;
    private Long purchase;
    private Integer deleted;
    private Date createTime;
    private Date updateTime;
}