package com.company.training.controller;

import com.company.training.entity.Student;
import com.company.training.entity.StudentCourseAppraise;
import com.company.training.entity.vo.Result;
import com.company.training.service.StudentCourseAppraiseService;
import com.company.training.service.StudentService;
import com.company.training.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student-course-appraise")
public class StudentCourseAppraiseController {

    @Autowired
    private StudentCourseAppraiseService studentCourseAppraiseService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private JwtUtil jwtUtil;

    // 获取课程的所有评价
    @GetMapping("/course/{couId}")
    public Result<List<StudentCourseAppraise>> getAppraisesByCourseId(@PathVariable Long couId) {
        List<StudentCourseAppraise> appraises = studentCourseAppraiseService.getAppraisesByCourseId(couId);
        return Result.success(appraises);
    }

    // 获取课程评价统计信息（平均分、总数、评价列表）
    @GetMapping("/course/{couId}/statistics")
    public Result<Map<String, Object>> getCourseAppraiseStatistics(@PathVariable Long couId) {
        Map<String, Object> statistics = studentCourseAppraiseService.getCourseAppraiseStatistics(couId);
        return Result.success(statistics);
    }

    // 获取学生对特定课程的评价
    @GetMapping("/student-course")
    public Result<StudentCourseAppraise> getAppraiseByStudentAndCourse(
            @RequestParam Long couId, HttpServletRequest request) {
        try {
            // 从JWT获取用户ID
            String token = request.getHeader("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Long userId = jwtUtil.parseUserId(token);
            
            // 根据用户ID获取学生信息
            Student student = studentService.getStudentByUserId(userId);
            if (student == null) {
                return Result.error("学生信息不存在");
            }
            
            StudentCourseAppraise appraise = studentCourseAppraiseService.getAppraiseByStudentAndCourse(student.getId(), couId);
            return Result.success(appraise);
        } catch (Exception e) {
            return Result.error("获取评价失败：" + e.getMessage());
        }
    }

    // 学生提交课程评价
    @PostMapping("/submit")
    public Result<String> submitAppraise(@RequestBody StudentCourseAppraise appraise, HttpServletRequest request) {
        try {
            // 从JWT获取用户ID
            String token = request.getHeader("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Long userId = jwtUtil.parseUserId(token);
            
            // 根据用户ID获取学生信息
            Student student = studentService.getStudentByUserId(userId);
            if (student == null) {
                return Result.error("学生信息不存在");
            }
            
            // 设置学生ID
            appraise.setStuId(student.getId());
            
            // 检查是否已经评价过
            StudentCourseAppraise existingAppraise = studentCourseAppraiseService.getAppraiseByStudentAndCourse(
                    student.getId(), appraise.getCouId());
            
            boolean success;
            if (existingAppraise != null) {
                // 更新现有评价
                appraise.setId(existingAppraise.getId());
                success = studentCourseAppraiseService.updateAppraise(appraise);
            } else {
                // 创建新评价
                success = studentCourseAppraiseService.saveAppraise(appraise);
            }
            
            if (success) {
                return Result.success("评价提交成功");
            } else {
                return Result.error("评价提交失败");
            }
        } catch (Exception e) {
            return Result.error("评价提交失败：" + e.getMessage());
        }
    }

    // 获取学生的所有评价
    @GetMapping("/my-appraises")
    public Result<List<StudentCourseAppraise>> getMyAppraises(HttpServletRequest request) {
        try {
            // 从JWT获取用户ID
            String token = request.getHeader("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Long userId = jwtUtil.parseUserId(token);
            
            // 根据用户ID获取学生信息
            Student student = studentService.getStudentByUserId(userId);
            if (student == null) {
                return Result.error("学生信息不存在");
            }
            
            List<StudentCourseAppraise> appraises = studentCourseAppraiseService.getAppraisesByStudentId(student.getId());
            return Result.success(appraises);
        } catch (Exception e) {
            return Result.error("获取评价失败：" + e.getMessage());
        }
    }

    // 删除评价
    @DeleteMapping("/{id}")
    public Result<String> deleteAppraise(@PathVariable Long id, HttpServletRequest request) {
        try {
            // 从JWT获取用户ID
            String token = request.getHeader("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Long userId = jwtUtil.parseUserId(token);
            
            // 根据用户ID获取学生信息
            Student student = studentService.getStudentByUserId(userId);
            if (student == null) {
                return Result.error("学生信息不存在");
            }
            
            // 验证评价是否属于当前学生
            StudentCourseAppraise appraise = studentCourseAppraiseService.getAppraiseById(id);
            if (appraise == null || !appraise.getStuId().equals(student.getId())) {
                return Result.error("无权删除此评价");
            }
            
            boolean success = studentCourseAppraiseService.deleteAppraise(id);
            if (success) {
                return Result.success("评价删除成功");
            } else {
                return Result.error("评价删除失败");
            }
        } catch (Exception e) {
            return Result.error("评价删除失败：" + e.getMessage());
        }
    }
}