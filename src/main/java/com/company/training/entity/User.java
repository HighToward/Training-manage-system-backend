package com.company.training.entity;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class User {
    private Long id;
    private Integer role;
    private String username;
    private String password;
    private String pic;
    private LocalDateTime createTime;
    private Integer deleted;
    private LocalDateTime updateTime;
}