package com.company.training.service;

import com.company.training.entity.Information;
import com.company.training.entity.InformationCollection;
import com.company.training.entity.InformationComments;

import java.util.List;

public interface InformationService {
    // 资讯管理
    Information createInformation(Information information);
    
    Information getInformationById(Long id);
    
    List<Information> getAllInformation();
    
    List<Information> getInformationByTeacherId(Long teaId);
    
    Information updateInformation(Information information);
    
    boolean deleteInformation(Long id);
    
    // 资讯点赞
    boolean likeInformation(Long stuId, Long infoId);
    
    boolean unlikeInformation(Long stuId, Long infoId);
    
    boolean isLiked(Long stuId, Long infoId);
    
    // 资讯收藏
    boolean collectInformation(Long stuId, Long infoId);
    
    boolean uncollectInformation(Long stuId, Long infoId);
    
    boolean isCollected(Long stuId, Long infoId);
    
    List<InformationCollection> getCollectionsByStudentId(Long stuId);
    
    // 资讯评论
    InformationComments createComment(InformationComments comment);
    
    List<InformationComments> getCommentsByInfoId(Long infoId);
    
    List<InformationComments> getRepliesByParentId(Long parentId);
    
    boolean deleteComment(Long commentId);
    
    // 评论点赞
    boolean likeComment(Long stuId, Long commentId);
    
    boolean unlikeComment(Long stuId, Long commentId);
    
    boolean isCommentLiked(Long stuId, Long commentId);
}