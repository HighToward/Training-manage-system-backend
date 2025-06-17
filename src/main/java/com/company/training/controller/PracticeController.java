package com.company.training.controller;

import com.company.training.entity.Practice;
import com.company.training.entity.Course;
import com.company.training.entity.vo.Result;
import com.company.training.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practice")
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    @GetMapping("/list/{courseId}")
    public Result<List<Practice>> getPracticeList(@PathVariable Long courseId) {
        List<Practice> practices = practiceService.getPracticeList(courseId);
        return Result.success(practices);
    }

    @GetMapping("/course/{courseId}")
    public Result<Course> getCourseInfo(@PathVariable Long courseId) {
        Course course = practiceService.getCourseInfo(courseId);
        return Result.success(course);
    }

    @PostMapping
    public Result<Boolean> savePractice(@RequestBody Practice practice) {
        boolean success = practiceService.savePractice(practice);
        return success ? Result.success(true) : Result.error("保存失败");
    }

    @PutMapping
    public Result<Boolean> updatePractice(@RequestBody Practice practice) {
        boolean success = practiceService.updatePractice(practice);
        return success ? Result.success(true) : Result.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deletePractice(@PathVariable Long id) {
        boolean success = practiceService.deletePractice(id);
        return success ? Result.success(true) : Result.error("删除失败");
    }

    @PostMapping("/batch")
    public Result<Boolean> batchSavePractices(@RequestBody List<Practice> practices) {
        boolean success = practiceService.batchSavePractices(practices);
        return success ? Result.success(true) : Result.error("批量保存失败");
    }

    @GetMapping("/all")
    public Result<List<Practice>> getAllPractices() {
        List<Practice> practices = practiceService.getAllPractices();
        return Result.success(practices);
    }

    @GetMapping("/{id}")
    public Result<Practice> getPracticeById(@PathVariable Long id) {
        Practice practice = practiceService.getPracticeById(id);
        return practice != null ? Result.success(practice) : Result.error("实践不存在");
    }

    @GetMapping("/teacher/{teacherId}")
    public Result<List<Practice>> getPracticesByTeacherId(@PathVariable Long teacherId) {
        List<Practice> practices = practiceService.getPracticesByTeacherId(teacherId);
        return Result.success(practices);
    }
}