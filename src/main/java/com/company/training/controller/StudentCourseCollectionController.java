package com.company.training.controller;

import com.company.training.entity.vo.Result;
import com.company.training.service.StudentCourseCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/collection")
@CrossOrigin
public class StudentCourseCollectionController {
    
    @Autowired
    private StudentCourseCollectionService collectionService;
    
    /**
     * 添加收藏
     */
    @PostMapping("/add")
    public Result addCollection(@RequestParam Long stuId, @RequestParam Long couId) {
        return collectionService.addCollection(stuId, couId);
    }
    
    /**
     * 取消收藏
     */
    @DeleteMapping("/remove")
    public Result removeCollection(@RequestParam Long stuId, @RequestParam Long couId) {
        return collectionService.removeCollection(stuId, couId);
    }
    
    /**
     * 获取学生的收藏列表
     */
    @GetMapping("/list/{stuId}")
    public Result getCollectionsByStuId(@PathVariable Long stuId) {
        return collectionService.getCollectionsByStuId(stuId);
    }
    
    /**
     * 检查收藏状态
     */
    @GetMapping("/check")
    public Result checkCollectionStatus(@RequestParam Long stuId, @RequestParam Long couId) {
        return collectionService.checkCollectionStatus(stuId, couId);
    }
    
    /**
     * 获取课程收藏数量
     */
    @GetMapping("/count/{couId}")
    public Result getCollectionCount(@PathVariable Long couId) {
        return collectionService.getCollectionCountByCouId(couId);
    }
}