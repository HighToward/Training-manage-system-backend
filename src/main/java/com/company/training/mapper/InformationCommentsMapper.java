package com.company.training.mapper;

import com.company.training.entity.InformationComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationCommentsMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(InformationComments record);
    
    InformationComments selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(InformationComments record);
    
    List<InformationComments> selectByInfoId(Long infoId);
    
    List<InformationComments> selectByParentId(Long parentCommentsId);
    
    int updateLikeCount(@Param("id") Long id, @Param("count") Long count);
    
    int countByInfoId(Long infoId);
}