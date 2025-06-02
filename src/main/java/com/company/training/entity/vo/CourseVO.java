package com.company.training.entity.vo;

import com.company.training.entity.Course;
import lombok.Data;

@Data
@lombok.EqualsAndHashCode(callSuper = false)
public class CourseVO extends Course {
    private String teaName;
    private String typeName;
    private String parentTypeName;
}