package com.company.training.mapper;

import com.company.training.entity.InformationComments;
import com.company.training.dto.InformationCommentsDTO;
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
    
    // 新增：关联查询评论和用户信息
    List<InformationCommentsDTO> selectByInfoIdWithUserInfo(Long infoId);
}