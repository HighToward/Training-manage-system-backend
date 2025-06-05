package com.company.training.mapper;

import com.company.training.entity.InformationCommentsLike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationCommentsLikeMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(InformationCommentsLike record);
    
    InformationCommentsLike selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(InformationCommentsLike record);
    
    InformationCommentsLike selectByStuIdAndCommentId(@Param("stuId") Long stuId, @Param("infoComId") Long infoComId);
    
    int deleteByStuIdAndCommentId(@Param("stuId") Long stuId, @Param("infoComId") Long infoComId);
    
    int countByCommentId(Long infoComId);
}