package com.company.training.mapper;

import com.company.training.entity.InformationLike;
import org.apache.ibatis.annotations.Param;

public interface InformationLikeMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(InformationLike record);
    
    InformationLike selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(InformationLike record);
    
    InformationLike selectByStuIdAndInfoId(@Param("stuId") Long stuId, @Param("infoId") Long infoId);
    
    int deleteByStuIdAndInfoId(@Param("stuId") Long stuId, @Param("infoId") Long infoId);
    
    int countByInfoId(Long infoId);
}