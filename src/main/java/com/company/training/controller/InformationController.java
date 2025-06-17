package com.company.training.controller;

import com.company.training.entity.*;
import com.company.training.entity.vo.Result;
import com.company.training.service.InformationService;
import com.company.training.dto.InformationCommentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/information")
public class InformationController {
    
    @Autowired
    private InformationService informationService;
    
    // 获取所有资讯
    @GetMapping("/list")
    public Result<List<Information>> getAllInformation() {
        try {
            List<Information> informationList = informationService.getAllInformation();
            return Result.success(informationList);
        } catch (Exception e) {
            return Result.error("获取资讯列表失败: " + e.getMessage());
        }
    }
    
    // 根据ID获取资讯详情
    @GetMapping("/{id}")
    public Result<Information> getInformationById(@PathVariable Long id) {
        try {
            Information information = informationService.getInformationById(id);
            if (information != null) {
                return Result.success(information);
            } else {
                return Result.error("资讯不存在");
            }
        } catch (Exception e) {
            return Result.error("获取资讯详情失败: " + e.getMessage());
        }
    }
    
    // 根据教师ID获取资讯
    @GetMapping("/teacher/{teaId}")
    public Result<List<Information>> getInformationByTeacherId(@PathVariable Long teaId) {
        try {
            List<Information> informationList = informationService.getInformationByTeacherId(teaId);
            return Result.success(informationList);
        } catch (Exception e) {
            return Result.error("获取教师资讯失败: " + e.getMessage());
        }
    }
    
    // 创建资讯
    @PostMapping
    public Result<Information> createInformation(@RequestBody Information information) {
        try {
            Information createdInfo = informationService.createInformation(information);
            return Result.success(createdInfo);
        } catch (Exception e) {
            return Result.error("创建资讯失败: " + e.getMessage());
        }
    }
    
    // 更新资讯
    @PutMapping("/{id}")
    public Result<Information> updateInformation(@PathVariable Long id, @RequestBody Information information) {
        try {
            information.setId(id);
            Information updatedInfo = informationService.updateInformation(information);
            return Result.success(updatedInfo);
        } catch (Exception e) {
            return Result.error("更新资讯失败: " + e.getMessage());
        }
    }
    
    // 删除资讯
    @DeleteMapping("/{id}")
    public Result<String> deleteInformation(@PathVariable Long id) {
        try {
            boolean success = informationService.deleteInformation(id);
            if (success) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败");
            }
        } catch (Exception e) {
            return Result.error("删除资讯失败: " + e.getMessage());
        }
    }
    
    // 点赞资讯
    @PostMapping("/{infoId}/like/{stuId}")
    public Result<String> likeInformation(@PathVariable Long infoId, @PathVariable Long stuId) {
        try {
            boolean success = informationService.likeInformation(stuId, infoId);
            if (success) {
                return Result.success("点赞成功");
            } else {
                return Result.error("已经点赞过了");
            }
        } catch (Exception e) {
            return Result.error("点赞失败: " + e.getMessage());
        }
    }
    
    // 取消点赞资讯
    @DeleteMapping("/{infoId}/like/{stuId}")
    public Result<String> unlikeInformation(@PathVariable Long infoId, @PathVariable Long stuId) {
        try {
            boolean success = informationService.unlikeInformation(stuId, infoId);
            if (success) {
                return Result.success("取消点赞成功");
            } else {
                return Result.error("取消点赞失败");
            }
        } catch (Exception e) {
            return Result.error("取消点赞失败: " + e.getMessage());
        }
    }
    
    // 收藏资讯
    @PostMapping("/{infoId}/collect/{stuId}")
    public Result<String> collectInformation(@PathVariable Long infoId, @PathVariable Long stuId) {
        try {
            boolean success = informationService.collectInformation(stuId, infoId);
            if (success) {
                return Result.success("收藏成功");
            } else {
                return Result.error("已经收藏过了");
            }
        } catch (Exception e) {
            return Result.error("收藏失败: " + e.getMessage());
        }
    }
    
    // 取消收藏资讯
    @DeleteMapping("/{infoId}/collect/{stuId}")
    public Result<String> uncollectInformation(@PathVariable Long infoId, @PathVariable Long stuId) {
        try {
            boolean success = informationService.uncollectInformation(stuId, infoId);
            if (success) {
                return Result.success("取消收藏成功");
            } else {
                return Result.error("取消收藏失败");
            }
        } catch (Exception e) {
            return Result.error("取消收藏失败: " + e.getMessage());
        }
    }
    
    // 获取学生收藏的资讯
    @GetMapping("/collections/{stuId}")
    public Result<List<InformationCollection>> getCollectionsByStudentId(@PathVariable Long stuId) {
        try {
            List<InformationCollection> collections = informationService.getCollectionsByStudentId(stuId);
            return Result.success(collections);
        } catch (Exception e) {
            return Result.error("获取收藏列表失败: " + e.getMessage());
        }
    }
    
    // 检查用户是否点赞了资讯
    @GetMapping("/{infoId}/like/status/{stuId}")
    public Result<Boolean> checkLikeStatus(@PathVariable Long infoId, @PathVariable Long stuId) {
        try {
            boolean isLiked = informationService.isLiked(stuId, infoId);
            return Result.success(isLiked);
        } catch (Exception e) {
            return Result.error("检查点赞状态失败: " + e.getMessage());
        }
    }
    
    // 检查用户是否收藏了资讯
    @GetMapping("/{infoId}/collect/status/{stuId}")
    public Result<Boolean> checkCollectStatus(@PathVariable Long infoId, @PathVariable Long stuId) {
        try {
            boolean isCollected = informationService.isCollected(stuId, infoId);
            return Result.success(isCollected);
        } catch (Exception e) {
            return Result.error("检查收藏状态失败: " + e.getMessage());
        }
    }
    
    // 检查用户是否点赞了评论
    @GetMapping("/comments/{commentId}/like/status/{stuId}")
    public Result<Boolean> checkCommentLikeStatus(@PathVariable Long commentId, @PathVariable Long stuId) {
        try {
            boolean isLiked = informationService.isCommentLiked(stuId, commentId);
            return Result.success(isLiked);
        } catch (Exception e) {
            return Result.error("检查评论点赞状态失败: " + e.getMessage());
        }
    }
    
    // 获取资讯评论
    @GetMapping("/{id}/comments")
    public Result<List<InformationCommentsDTO>> getCommentsByInfoId(@PathVariable Long id) {
        try {
            List<InformationCommentsDTO> comments = informationService.getCommentsByInfoIdWithUserInfo(id);
            return Result.success(comments);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取评论失败");
        }
    }
    
    // 创建评论
    @PostMapping("/{infoId}/comments")
    public Result<InformationComments> createComment(@PathVariable Long infoId, @RequestBody InformationComments comment) {
        try {
            comment.setInfoId(infoId);
            InformationComments createdComment = informationService.createComment(comment);
            return Result.success(createdComment);
        } catch (Exception e) {
            return Result.error("创建评论失败: " + e.getMessage());
        }
    }
    
    // 删除评论
    @DeleteMapping("/comments/{commentId}")
    public Result<String> deleteComment(@PathVariable Long commentId) {
        try {
            boolean success = informationService.deleteComment(commentId);
            if (success) {
                return Result.success("删除评论成功");
            } else {
                return Result.error("删除评论失败");
            }
        } catch (Exception e) {
            return Result.error("删除评论失败: " + e.getMessage());
        }
    }
    
    // 点赞评论
    @PostMapping("/comments/{commentId}/like/{stuId}")
    public Result<String> likeComment(@PathVariable Long commentId, @PathVariable Long stuId) {
        try {
            boolean success = informationService.likeComment(stuId, commentId);
            if (success) {
                return Result.success("点赞评论成功");
            } else {
                return Result.error("已经点赞过了");
            }
        } catch (Exception e) {
            return Result.error("点赞评论失败: " + e.getMessage());
        }
    }
    
    // 取消点赞评论
    @DeleteMapping("/comments/{commentId}/like/{stuId}")
    public Result<String> unlikeComment(@PathVariable Long commentId, @PathVariable Long stuId) {
        try {
            boolean success = informationService.unlikeComment(stuId, commentId);
            if (success) {
                return Result.success("取消点赞评论成功");
            } else {
                return Result.error("取消点赞评论失败");
            }
        } catch (Exception e) {
            return Result.error("取消点赞评论失败: " + e.getMessage());
        }
    }
}