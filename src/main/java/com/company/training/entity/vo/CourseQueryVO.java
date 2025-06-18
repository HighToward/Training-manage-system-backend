package com.company.training.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class CourseQueryVO {
    private String couName;
    private List<Long> couTypeIds;
    private Long teaId;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    
    // 搜索相关字段
    private String keyword;
    private String category;
    private String sortBy;
    private Integer page;
    
    // 兼容性方法
    public void setPage(int page) {
        this.page = page;
        this.pageNum = page;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}