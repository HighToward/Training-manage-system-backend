package com.company.training.mapper;

import com.company.training.entity.Chapter;
import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Chapter record);

    Chapter selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Chapter record);

    List<Chapter> selectByCourseId(Long courseId);

    int deleteByCourseId(Long courseId);

    List<Chapter> selectAll();


}
