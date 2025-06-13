package com.company.training.entity;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class StudentOrderDetail {
    private Long id;
    private Long orderId;
    private Long couId;
    private Long couPrice;
    private String couPic;
    private String teaName;
    private String couName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;
}