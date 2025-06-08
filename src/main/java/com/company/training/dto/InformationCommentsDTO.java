package com.company.training.dto;

import lombok.Data;
import java.util.Date;

@Data
public class InformationCommentsDTO {
    private Long id;
    private Long infoId;
    private Long userId;
    private String content;
    private Long infoLikeNum;
    private Long atId;
    private Long parentCommentsId;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
    
    // 用户信息字段
    private String userName;
    private String userAvatar;
}
