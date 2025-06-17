package com.company.training.service.impl;

import com.company.training.entity.*;
import com.company.training.mapper.*;
import com.company.training.service.InformationService;
import com.company.training.dto.InformationCommentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    
    @Autowired
    private InformationMapper informationMapper;
    
    @Autowired
    private InformationLikeMapper informationLikeMapper;
    
    @Autowired
    private InformationCollectionMapper informationCollectionMapper;
    
    @Autowired
    private InformationCommentsMapper informationCommentsMapper;
    
    @Autowired
    private InformationCommentsLikeMapper informationCommentsLikeMapper;
    
    @Override
    public Information createInformation(Information information) {
        information.setCreateTime(new Date());
        information.setUpdateTime(new Date());
        information.setDeleted(0);
        information.setInfoLike(0L);
        information.setInfoCollection(0L);
        information.setInfoComment(0L);
        informationMapper.insert(information);
        return information;
    }
    
    @Override
    public Information getInformationById(Long id) {
        return informationMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<Information> getAllInformation() {
        List<Information> informationList = informationMapper.selectAll();
        // 确保评论数是最新的
        for (Information info : informationList) {
            Long commentCount = (long) informationCommentsMapper.countByInfoId(info.getId());
            if (!commentCount.equals(info.getInfoComment())) {
                // 如果数据库中的评论数与实际不符，更新它
                informationMapper.updateCommentCount(info.getId(), commentCount);
                info.setInfoComment(commentCount);
            }
        }
        return informationList;
    }
    
    @Override
    public List<Information> getInformationByTeacherId(Long teaId) {
        return informationMapper.selectByTeacherId(teaId);
    }
    
    @Override
    public Information updateInformation(Information information) {
        information.setUpdateTime(new Date());
        
        // 确保统计字段不为 null，如果为 null 则设置为 0
        if (information.getInfoLike() == null) {
            information.setInfoLike(0L);
        }
        if (information.getInfoCollection() == null) {
            information.setInfoCollection(0L);
        }
        if (information.getInfoComment() == null) {
            information.setInfoComment(0L);
        }
        
        informationMapper.updateByPrimaryKey(information);
        return information;
    }
    
    @Override
    public boolean deleteInformation(Long id) {
        return informationMapper.deleteByPrimaryKey(id) > 0;
    }
    
    @Override
    @Transactional
    public boolean likeInformation(Long stuId, Long infoId) {
        // 检查是否已点赞（只查询未删除的记录）
        InformationLike existingLike = informationLikeMapper.selectByStuIdAndInfoId(stuId, infoId);
        if (existingLike != null) {
            return false; // 已经点赞过
        }
        
        // 检查是否存在已删除的记录
        InformationLike deletedLike = informationLikeMapper.selectByStuIdAndInfoIdIncludeDeleted(stuId, infoId);
        if (deletedLike != null && deletedLike.getDeleted() == 1) {
            // 恢复已删除的记录
            deletedLike.setDeleted(0);
            deletedLike.setUpdateTime(new Date());
            informationLikeMapper.updateByPrimaryKey(deletedLike);
        } else {
            // 创建新的点赞记录
            InformationLike like = new InformationLike();
            like.setStuId(stuId);
            like.setInfoId(infoId);
            like.setCreateTime(new Date());
            like.setUpdateTime(new Date());
            like.setDeleted(0);
            informationLikeMapper.insert(like);
        }
        
        // 更新资讯点赞数
        Long likeCount = (long) informationLikeMapper.countByInfoId(infoId);
        informationMapper.updateLikeCount(infoId, likeCount);
        
        return true;
    }
    
    @Override
    @Transactional
    public boolean unlikeInformation(Long stuId, Long infoId) {
        int result = informationLikeMapper.deleteByStuIdAndInfoId(stuId, infoId);
        if (result > 0) {
            // 更新资讯点赞数
            Long likeCount = (long) informationLikeMapper.countByInfoId(infoId);
            informationMapper.updateLikeCount(infoId, likeCount);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isLiked(Long stuId, Long infoId) {
        return informationLikeMapper.selectByStuIdAndInfoId(stuId, infoId) != null;
    }
    
    @Override
    @Transactional
    public boolean collectInformation(Long stuId, Long infoId) {
        // 检查是否已收藏（只查询未删除的记录）
        InformationCollection existingCollection = informationCollectionMapper.selectByStuIdAndInfoId(stuId, infoId);
        if (existingCollection != null) {
            return false; // 已经收藏过
        }
        
        // 检查是否存在已删除的记录
        InformationCollection deletedCollection = informationCollectionMapper.selectByStuIdAndInfoIdIncludeDeleted(stuId, infoId);
        if (deletedCollection != null && deletedCollection.getDeleted() == 1) {
            // 恢复已删除的记录
            deletedCollection.setDeleted(0);
            deletedCollection.setUpdateTime(new Date());
            informationCollectionMapper.updateByPrimaryKey(deletedCollection);
        } else {
            // 创建新的收藏记录
            InformationCollection collection = new InformationCollection();
            collection.setStuId(stuId);
            collection.setInfoId(infoId);
            collection.setCreateTime(new Date());
            collection.setUpdateTime(new Date());
            collection.setDeleted(0);
            informationCollectionMapper.insert(collection);
        }
        
        // 更新资讯收藏数
        Long collectionCount = (long) informationCollectionMapper.countByInfoId(infoId);
        informationMapper.updateCollectionCount(infoId, collectionCount);
        
        return true;
    }
    
    @Override
    @Transactional
    public boolean uncollectInformation(Long stuId, Long infoId) {
        int result = informationCollectionMapper.deleteByStuIdAndInfoId(stuId, infoId);
        if (result > 0) {
            // 更新资讯收藏数
            Long collectionCount = (long) informationCollectionMapper.countByInfoId(infoId);
            informationMapper.updateCollectionCount(infoId, collectionCount);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isCollected(Long stuId, Long infoId) {
        return informationCollectionMapper.selectByStuIdAndInfoId(stuId, infoId) != null;
    }
    
    @Override
    public List<InformationCollection> getCollectionsByStudentId(Long stuId) {
        return informationCollectionMapper.selectByStudentId(stuId);
    }
    
    @Override
    @Transactional
    public InformationComments createComment(InformationComments comment) {
        comment.setCreateTime(new Date());
        comment.setDeleted(0);
        comment.setInfoLikeNum(0L);
        // 设置默认值以避免 NOT NULL 约束错误
        if (comment.getAtId() == null) {
            comment.setAtId(0L); // 0表示未@任何人
        }
        if (comment.getParentCommentsId() == null) {
            comment.setParentCommentsId(0L); // 0表示一级评论
        }
        
        informationCommentsMapper.insert(comment);
        
        // 更新资讯评论数
        Long commentCount = (long) informationCommentsMapper.countByInfoId(comment.getInfoId());
        informationMapper.updateCommentCount(comment.getInfoId(), commentCount);
        
        return comment;
    }
    
    @Override
    public List<InformationComments> getCommentsByInfoId(Long infoId) {
        return informationCommentsMapper.selectByInfoId(infoId);
    }
    
    @Override
    public List<InformationCommentsDTO> getCommentsByInfoIdWithUserInfo(Long infoId) {
        return informationCommentsMapper.selectByInfoIdWithUserInfo(infoId);
    }
    
    @Override
    public List<InformationComments> getRepliesByParentId(Long parentId) {
        return informationCommentsMapper.selectByParentId(parentId);
    }
    
    @Override
    @Transactional
    public boolean deleteComment(Long commentId) {
        InformationComments comment = informationCommentsMapper.selectByPrimaryKey(commentId);
        if (comment != null) {
            int result = informationCommentsMapper.deleteByPrimaryKey(commentId);
            if (result > 0) {
                // 更新资讯评论数
                Long commentCount = (long) informationCommentsMapper.countByInfoId(comment.getInfoId());
                informationMapper.updateCommentCount(comment.getInfoId(), commentCount);
                return true;
            }
        }
        return false;
    }
    
    @Override
    @Transactional
    public boolean likeComment(Long stuId, Long commentId) {
        // 检查是否已点赞
        InformationCommentsLike existingLike = informationCommentsLikeMapper.selectByStuIdAndCommentId(stuId, commentId);
        if (existingLike != null) {
            return false; // 已经点赞过
        }
        
        // 创建点赞记录
        InformationCommentsLike like = new InformationCommentsLike();
        like.setStuId(stuId);
        like.setInfoComId(commentId);
        like.setCreateTime(new Date());
        like.setUpdateTime(new Date());
        like.setDeleted(0);
        informationCommentsLikeMapper.insert(like);
        
        // 更新评论点赞数
        Long likeCount = (long) informationCommentsLikeMapper.countByCommentId(commentId);
        informationCommentsMapper.updateLikeCount(commentId, likeCount);
        
        return true;
    }
    
    @Override
    @Transactional
    public boolean unlikeComment(Long stuId, Long commentId) {
        int result = informationCommentsLikeMapper.deleteByStuIdAndCommentId(stuId, commentId);
        if (result > 0) {
            // 更新评论点赞数
            Long likeCount = (long) informationCommentsLikeMapper.countByCommentId(commentId);
            informationCommentsMapper.updateLikeCount(commentId, likeCount);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isCommentLiked(Long stuId, Long commentId) {
        return informationCommentsLikeMapper.selectByStuIdAndCommentId(stuId, commentId) != null;
    }
}