package com.company.training.entity;

import java.time.LocalDateTime;

/**
 * 学生课程点赞表
 */
public class StudentCourseFancy {
    private Long id; // 点赞记录ID
    private Long stuId; // 学生ID
    private Long couId; // 课程ID
    private LocalDateTime createTime; // 点赞时间
    private LocalDateTime updateTime; // 更新时间
    private Integer deleted; // 删除标记(0:未删除,1:已删除)

    public StudentCourseFancy() {
    }

    public StudentCourseFancy(Long stuId, Long couId) {
        this.stuId = stuId;
        this.couId = couId;
        this.deleted = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getCouId() {
        return couId;
    }

    public void setCouId(Long couId) {
        this.couId = couId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "StudentCourseFancy{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", couId=" + couId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}