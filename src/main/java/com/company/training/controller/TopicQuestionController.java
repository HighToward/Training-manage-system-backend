package com.company.training.controller;

import com.company.training.entity.TopicQuestion;
import com.company.training.entity.TopicQuestionComment;
import com.company.training.entity.vo.Result;
import com.company.training.service.TopicQuestionService;
import com.company.training.service.TopicQuestionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/topicQuestion")
@CrossOrigin
public class TopicQuestionController {

    @Autowired
    private TopicQuestionService topicQuestionService;
    
    @Autowired
    private TopicQuestionCommentService topicQuestionCommentService;

    // 获取所有问题
    @GetMapping("/list")
    public Result<List<TopicQuestion>> getTopicQuestionList() {
        try {
            List<TopicQuestion> list = topicQuestionService.getTopicQuestionList();
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("获取问题列表失败: " + e.getMessage());
        }
    }

    // 根据ID获取问题详情
    @GetMapping("/{id}")
    public Result<TopicQuestion> getTopicQuestionById(@PathVariable Long id) {
        try {
            TopicQuestion topicQuestion = topicQuestionService.getTopicQuestionById(id);
            if (topicQuestion != null) {
                return Result.success(topicQuestion);
            } else {
                return Result.error("问题不存在");
            }
        } catch (Exception e) {
            return Result.error("获取问题详情失败: " + e.getMessage());
        }
    }

    // 根据学生ID获取问题
    @GetMapping("/student/{stuId}")
    public Result<List<TopicQuestion>> getTopicQuestionByStudentId(@PathVariable Long stuId) {
        try {
            List<TopicQuestion> list = topicQuestionService.getTopicQuestionByStudentId(stuId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("获取学生问题失败: " + e.getMessage());
        }
    }

    // 根据班级ID获取问题
    @GetMapping("/class/{classId}")
    public Result<List<TopicQuestion>> getTopicQuestionByClassId(@PathVariable Long classId) {
        try {
            List<TopicQuestion> list = topicQuestionService.getTopicQuestionByClassId(classId);
            return Result.success(list);
        } catch (Exception e) {
            return Result.error("获取班级问题失败: " + e.getMessage());
        }
    }

    // 创建问题
    @PostMapping("/create")
    public Result<Void> createTopicQuestion(@RequestBody TopicQuestion topicQuestion) {
        try {
            topicQuestionService.createTopicQuestion(topicQuestion);
            return Result.success();
        } catch (Exception e) {
            return Result.error("创建问题失败: " + e.getMessage());
        }
    }

    // 更新问题
    @PutMapping("/update/{id}")
    public Result<Void> updateTopicQuestion(@PathVariable Long id, @RequestBody TopicQuestion topicQuestion) {
        try {
            topicQuestion.setId(id);
            topicQuestionService.updateTopicQuestion(topicQuestion);
            return Result.success();
        } catch (Exception e) {
            return Result.error("更新问题失败: " + e.getMessage());
        }
    }

    // 删除问题
    @DeleteMapping("/delete/{id}")
    public Result<Void> deleteTopicQuestion(@PathVariable Long id) {
        try {
            topicQuestionService.deleteTopicQuestion(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("删除问题失败: " + e.getMessage());
        }
    }

    // 点赞问题
    @PostMapping("/like/{id}")
    public Result<Void> likeTopicQuestion(@PathVariable Long id, @RequestParam Long stuId) {
        try {
            topicQuestionService.likeTopicQuestion(id, stuId);
            return Result.success();
        } catch (Exception e) {
            return Result.error("点赞失败: " + e.getMessage());
        }
    }

    // 收藏问题
    @PostMapping("/collect/{id}")
    public Result<Void> collectTopicQuestion(@PathVariable Long id, @RequestParam Long stuId) {
        try {
            topicQuestionService.collectTopicQuestion(id, stuId);
            return Result.success();
        } catch (Exception e) {
            return Result.error("收藏失败: " + e.getMessage());
        }
    }

    // 获取问题类型列表
    @GetMapping("/types")
    public Result<List<String>> getQuestionTypes() {
        try {
            List<String> types = topicQuestionService.getQuestionTypes();
            return Result.success(types);
        } catch (Exception e) {
            return Result.error("获取问题类型失败: " + e.getMessage());
        }
    }
    
    // 获取问题评论列表
    @GetMapping("/{id}/comments")
    public Result<List<TopicQuestionComment>> getQuestionComments(@PathVariable Long id) {
        try {
            List<TopicQuestionComment> comments = topicQuestionCommentService.getCommentsWithUserInfoByQuestionId(id);
            return Result.success(comments);
        } catch (Exception e) {
            return Result.error("获取评论列表失败: " + e.getMessage());
        }
    }
    
    // 创建问题评论
    @PostMapping("/{id}/comments")
    public Result<TopicQuestionComment> createQuestionComment(@PathVariable Long id, @RequestBody TopicQuestionComment comment) {
        try {
            comment.setQId(id);
            topicQuestionCommentService.createComment(comment);
            // 获取创建后的评论信息（包含用户信息）
            TopicQuestionComment createdComment = topicQuestionCommentService.getCommentWithUserInfoById(comment.getId());
            return Result.success(createdComment);
        } catch (Exception e) {
            return Result.error("创建评论失败: " + e.getMessage());
        }
    }
    
    // 删除问题评论
    @DeleteMapping("/comments/{commentId}")
    public Result<Void> deleteQuestionComment(@PathVariable Long commentId) {
        try {
            topicQuestionCommentService.deleteComment(commentId);
            return Result.success();
        } catch (Exception e) {
            return Result.error("删除评论失败: " + e.getMessage());
        }
    }
    
    // 获取评论的回复列表
    @GetMapping("/comments/{commentId}/replies")
    public Result<List<TopicQuestionComment>> getCommentReplies(@PathVariable Long commentId) {
        try {
            List<TopicQuestionComment> replies = topicQuestionCommentService.getRepliesByParentId(commentId);
            return Result.success(replies);
        } catch (Exception e) {
            return Result.error("获取回复失败: " + e.getMessage());
        }
    }
    
    // 获取问题图片列表
    @GetMapping("/{id}/images")
    public Result<List<String>> getQuestionImages(@PathVariable Long id) {
        try {
            List<String> images = topicQuestionService.getQuestionImages(id);
            return Result.success(images);
        } catch (Exception e) {
            return Result.error("获取问题图片失败: " + e.getMessage());
        }
    }
    
    // 采纳问题
    @PutMapping("/{id}/adopt")
    public Result<Void> adoptQuestion(@PathVariable Long id) {
        try {
            topicQuestionService.adoptQuestion(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("采纳问题失败: " + e.getMessage());
        }
    }
    
    // 取消采纳问题
    @PutMapping("/{id}/cancel-adopt")
    public Result<Void> cancelAdoptQuestion(@PathVariable Long id) {
        try {
            topicQuestionService.cancelAdoptQuestion(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("取消采纳失败: " + e.getMessage());
        }
    }
    
    // 批量采纳问题
    @PutMapping("/batch-adopt")
    public Result<Void> batchAdoptQuestions(@RequestBody Map<String, List<Long>> request) {
        try {
            List<Long> ids = request.get("ids");
            if (ids == null || ids.isEmpty()) {
                return Result.error("请提供要采纳的问题ID列表");
            }
            topicQuestionService.batchAdoptQuestions(ids);
            return Result.success();
        } catch (Exception e) {
            return Result.error("批量采纳失败: " + e.getMessage());
        }
    }
    
    // 不采纳问题
    @PutMapping("/{id}/reject")
    public Result<Void> rejectQuestion(@PathVariable Long id) {
        try {
            topicQuestionService.rejectQuestion(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("不采纳问题失败: " + e.getMessage());
        }
    }
}