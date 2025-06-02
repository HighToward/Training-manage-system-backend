package com.company.training.controller;

import com.company.training.entity.Student;
import com.company.training.entity.TrainingClass;
import com.company.training.entity.vo.ClassQueryVO;
import com.company.training.entity.vo.CourseVO;
import com.company.training.entity.vo.Result;
import com.company.training.service.TrainingClassService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/class")
public class TrainingClassController {

    @Autowired
    private TrainingClassService trainingClassService;

    // --- Class Info Management ---
    @PostMapping
    public Result<Boolean> saveClass(@RequestBody TrainingClass trainingClass) {
        boolean success = trainingClassService.saveClass(trainingClass);
        return success ? Result.success(true) : Result.error("保存班级失败");
    }

    @PutMapping
    public Result<Boolean> updateClass(@RequestBody TrainingClass trainingClass) {
        boolean success = trainingClassService.updateClass(trainingClass);
        return success ? Result.success(true) : Result.error("更新班级失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteClass(@PathVariable Long id) {
        boolean success = trainingClassService.deleteClass(id);
        return success ? Result.success(true) : Result.error("删除班级失败");
    }

    @GetMapping("/{id}")
    public Result<TrainingClass> getClassById(@PathVariable Long id) {
        TrainingClass trainingClass = trainingClassService.getClassById(id);
        return Result.success(trainingClass);
    }

    @GetMapping("/list")
    public Result<PageInfo<TrainingClass>> getClassList(ClassQueryVO queryVO) {
        PageInfo<TrainingClass> pageInfo = trainingClassService.getClassList(queryVO);
        return Result.success(pageInfo);
    }

    @GetMapping("/all")
    public Result<List<TrainingClass>> getAllClasses() {
        List<TrainingClass> classes = trainingClassService.getAllClasses();
        return Result.success(classes);
    }

    // --- Class Student Management ---
    @GetMapping("/{classId}/students")
    public Result<List<Student>> getStudentsByClassId(@PathVariable Long classId) {
        List<Student> students = trainingClassService.getStudentsByClassId(classId);
        return Result.success(students);
    }

    @GetMapping("/{classId}/available-students")
    public Result<List<Student>> getAvailableStudentsForClass(@PathVariable Long classId) {
        List<Student> students = trainingClassService.getAvailableStudentsForClass(classId);
        return Result.success(students);
    }

    @PostMapping("/{classId}/students/{studentId}")
    public Result<Boolean> addStudentToClass(@PathVariable Long classId, @PathVariable Long studentId) {
        boolean success = trainingClassService.addStudentToClass(classId, studentId);
        return success ? Result.success(true) : Result.error("添加学生到班级失败");
    }

    @DeleteMapping("/{classId}/students/{studentId}")
    public Result<Boolean> removeStudentFromClass(@PathVariable Long classId, @PathVariable Long studentId) {
        boolean success = trainingClassService.removeStudentFromClass(classId, studentId);
        return success ? Result.success(true) : Result.error("从班级移除学生失败");
    }

    // --- Class Course Management ---
    @GetMapping("/{classId}/courses")
    public Result<List<CourseVO>> getCoursesByClassId(@PathVariable Long classId) { // <--- 修改返回类型
        List<CourseVO> courses = trainingClassService.getCoursesByClassId(classId);
        return Result.success(courses);
    }

    @GetMapping("/{classId}/available-courses")
    public Result<List<CourseVO>> getAvailableCoursesForClass(@PathVariable Long classId) { // <--- 修改返回类型
        List<CourseVO> courses = trainingClassService.getAvailableCoursesForClass(classId);
        return Result.success(courses);
    }

    @PostMapping("/{classId}/courses/{courseId}")
    public Result<Boolean> addCourseToClass(@PathVariable Long classId, @PathVariable Long courseId) {
        boolean success = trainingClassService.addCourseToClass(classId, courseId);
        return success ? Result.success(true) : Result.error("分配课程到班级失败");
    }

    @DeleteMapping("/{classId}/courses/{courseId}")
    public Result<Boolean> removeCourseFromClass(@PathVariable Long classId, @PathVariable Long courseId) {
        boolean success = trainingClassService.removeCourseFromClass(classId, courseId);
        return success ? Result.success(true) : Result.error("从班级移除课程失败");
    }
}