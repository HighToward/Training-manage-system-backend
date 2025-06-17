package com.company.training.controller;

import com.company.training.entity.StudentPractice;
import com.company.training.entity.vo.Result;
import com.company.training.service.StudentPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-practice")
public class StudentPracticeController {

    @Autowired
    private StudentPracticeService studentPracticeService;

    @GetMapping("/practice/{practiceId}")
    public Result<List<StudentPractice>> getStudentPracticesByPracticeId(@PathVariable Long practiceId) {
        List<StudentPractice> studentPractices = studentPracticeService.getStudentPracticesByPracticeId(practiceId);
        return Result.success(studentPractices);
    }

    @GetMapping("/student/{studentId}")
    public Result<List<StudentPractice>> getStudentPracticesByStudentId(@PathVariable Long studentId) {
        List<StudentPractice> studentPractices = studentPracticeService.getStudentPracticesByStudentId(studentId);
        return Result.success(studentPractices);
    }

    @PostMapping
    public Result<Boolean> saveStudentPractice(@RequestBody StudentPractice studentPractice) {
        boolean success = studentPracticeService.saveStudentPractice(studentPractice);
        return success ? Result.success(true) : Result.error("保存失败");
    }

    @PutMapping
    public Result<Boolean> updateStudentPractice(@RequestBody StudentPractice studentPractice) {
        boolean success = studentPracticeService.updateStudentPractice(studentPractice);
        return success ? Result.success(true) : Result.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteStudentPractice(@PathVariable Long id) {
        boolean success = studentPracticeService.deleteStudentPractice(id);
        return success ? Result.success(true) : Result.error("删除失败");
    }

    @DeleteMapping("/student/{studentId}/practice/{practiceId}")
    public Result<Boolean> deleteByStudentAndPractice(@PathVariable Long studentId, @PathVariable Long practiceId) {
        boolean success = studentPracticeService.deleteByStudentAndPractice(studentId, practiceId);
        return success ? Result.success(true) : Result.error("删除失败");
    }

    @GetMapping("/student/{studentId}/practice/{practiceId}")
    public Result<StudentPractice> getStudentPracticeByStudentAndPractice(@PathVariable Long studentId, @PathVariable Long practiceId) {
        StudentPractice studentPractice = studentPracticeService.getStudentPracticeByStudentAndPractice(studentId, practiceId);
        return studentPractice != null ? Result.success(studentPractice) : Result.error("记录不存在");
    }

    @GetMapping("/check/{studentId}/{practiceId}")
    public Result<Boolean> isStudentEnrolledInPractice(@PathVariable Long studentId, @PathVariable Long practiceId) {
        boolean enrolled = studentPracticeService.isStudentEnrolledInPractice(studentId, practiceId);
        return Result.success(enrolled);
    }
}