package com.company.training.controller;

import com.company.training.entity.Chapter;
import com.company.training.entity.Course;
import com.company.training.entity.vo.Result;
import com.company.training.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("/list/{courseId}")
    public Result<List<Chapter>> getChapterList(@PathVariable Long courseId) {
        List<Chapter> chapters = chapterService.getChapterList(courseId);
        return Result.success(chapters);
    }

    @GetMapping("/course/{courseId}")
    public Result<Course> getCourseInfo(@PathVariable Long courseId) {
        Course course = chapterService.getCourseInfo(courseId);
        return Result.success(course);
    }

    @PostMapping
    public Result<Boolean> saveChapter(@RequestBody Chapter chapter) {
        boolean success = chapterService.saveChapter(chapter);
        return success ? Result.success(true) : Result.error("保存失败");
    }

    @PutMapping
    public Result<Boolean> updateChapter(@RequestBody Chapter chapter) {
        boolean success = chapterService.updateChapter(chapter);
        return success ? Result.success(true) : Result.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteChapter(@PathVariable Long id) {
        boolean success = chapterService.deleteChapter(id);
        return success ? Result.success(true) : Result.error("删除失败");
    }

    @PostMapping("/batch")
    public Result<Boolean> batchSaveChapters(@RequestBody List<Chapter> chapters) {
        boolean success = chapterService.batchSaveChapters(chapters);
        return success ? Result.success(true) : Result.error("批量保存失败");
    }

    @GetMapping("/all")
    public Result<List<Chapter>> getAllChapters() {
        List<Chapter> chapters = chapterService.getAllChapters();
        return Result.success(chapters);
    }

}