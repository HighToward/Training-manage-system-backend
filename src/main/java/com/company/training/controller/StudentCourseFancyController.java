package com.company.training.controller;

import com.company.training.entity.vo.Result;
import com.company.training.service.StudentCourseFancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/fancy")
public class StudentCourseFancyController {
    
    @Autowired
    private StudentCourseFancyService fancyService;
    
    /**
     * 添加点赞
     */
    @PostMapping("/add")
    public Result addFancy(@RequestParam Long stuId, @RequestParam Long couId) {
        return fancyService.addFancy(stuId, couId);
    }
    
    /**
     * 取消点赞
     */
    @DeleteMapping("/remove")
    public Result removeFancy(@RequestParam Long stuId, @RequestParam Long couId) {
        return fancyService.removeFancy(stuId, couId);
    }
    
    /**
     * 获取学生的点赞列表
     */
    @GetMapping("/list/{stuId}")
    public Result getFanciesByStuId(@PathVariable Long stuId) {
        return fancyService.getFanciesByStuId(stuId);
    }
    
    /**
     * 检查点赞状态
     */
    @GetMapping("/check")
    public Result checkFancyStatus(@RequestParam Long stuId, @RequestParam Long couId) {
        return fancyService.checkFancyStatus(stuId, couId);
    }
    
    /**
     * 获取课程点赞数量
     */
    @GetMapping("/count/{couId}")
    public Result getFancyCountByCouId(@PathVariable Long couId) {
        return fancyService.getFancyCountByCouId(couId);
    }
}