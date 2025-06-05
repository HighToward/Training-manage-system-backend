package com.company.training.mapper;

import com.company.training.entity.Information;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(Information record);
    
    Information selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(Information record);
    
    List<Information> selectAll();
    
    List<Information> selectByTeacherId(Long teaId);
    
    int updateLikeCount(@Param("id") Long id, @Param("count") Long count);
    
    int updateCollectionCount(@Param("id") Long id, @Param("count") Long count);
    
    int updateCommentCount(@Param("id") Long id, @Param("count") Long count);
}