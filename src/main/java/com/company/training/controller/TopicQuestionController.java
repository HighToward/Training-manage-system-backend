package com.company.training.controller;

import com.company.training.entity.TopicQuestion;
import com.company.training.entity.vo.Result;
import com.company.training.service.TopicQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicQuestion")
@CrossOrigin
public class TopicQuestionController {

    @Autowired
    private TopicQuestionService topicQuestionService;

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
}