package com.company.training.mapper;

import com.company.training.entity.InformationCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationCollectionMapper {
    int deleteByPrimaryKey(Long id);
    
    int insert(InformationCollection record);
    
    InformationCollection selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(InformationCollection record);
    
    List<InformationCollection> selectByStudentId(Long stuId);
    
    InformationCollection selectByStuIdAndInfoId(@Param("stuId") Long stuId, @Param("infoId") Long infoId);
    
    InformationCollection selectByStuIdAndInfoIdIncludeDeleted(@Param("stuId") Long stuId, @Param("infoId") Long infoId);
    
    int deleteByStuIdAndInfoId(@Param("stuId") Long stuId, @Param("infoId") Long infoId);
    
    int countByInfoId(Long infoId);
}