package com.company.training.controller;

import com.company.training.entity.Student;
import com.company.training.entity.vo.Result;
// import com.company.training.entity.vo.StudentQueryVO; // If you implement full student CRUD
import com.company.training.entity.vo.StudentQueryVO;
import com.company.training.service.StudentService; // You'll need to create this service
// import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService; // Autowire the service

    // Endpoint for ClassStudentManage.vue
    @GetMapping("/all-active")
    public Result<List<Student>> getAllActiveStudents() {
        List<Student> students = studentService.getAllActiveStudents();
        return Result.success(students);
    }

    // Example for a full Student CRUD if you need it later
    @GetMapping("/list")
    public Result<PageInfo<Student>> getStudentList(StudentQueryVO queryVO) {
        PageInfo<Student> pageInfo = studentService.getStudentList(queryVO);
        return Result.success(pageInfo);
    }

    @PostMapping
    public Result<Boolean> saveStudent(@RequestBody Student student) {
        boolean success = studentService.saveStudent(student);
        return success ? Result.success(true) : Result.error("保存学生失败");
    }

    @PutMapping
    public Result<Boolean> updateStudent(@RequestBody Student student) {
        boolean success = studentService.updateStudent(student);
        return success ? Result.success(true) : Result.error("更新学生失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteStudent(@PathVariable Long id) {
        boolean success = studentService.deleteStudent(id);
        return success ? Result.success(true) : Result.error("删除学生失败");
    }

    @GetMapping("/{id}")
    public Result<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }
}