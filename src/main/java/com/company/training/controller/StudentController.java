package com.company.training.controller;

import com.company.training.entity.Student;
import com.company.training.entity.StudentOrderDetail;
import com.company.training.entity.TrainingClass;
import com.company.training.entity.Course;
import com.company.training.entity.vo.Result;
import com.company.training.entity.vo.StudentQueryVO;
import com.company.training.service.StudentService;
import com.company.training.util.JwtUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private JwtUtil jwtUtil;

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

    // 检查课程购买状态
    @GetMapping("/course/purchased/{courseId}")
    public ResponseEntity<?> checkCoursePurchased(@PathVariable Long courseId, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                return ResponseEntity.status(401).body(Map.of("code", 401, "message", "未提供有效的认证令牌"));
            }
            
            Long userId = jwtUtil.parseUserId(token);
            Student student = studentService.getStudentByUserId(userId);
            if (student == null) {
                return ResponseEntity.status(404).body(Map.of("code", 404, "message", "学生信息未找到"));
            }
            
            boolean purchased = studentService.checkCoursePurchased(student.getId(), courseId);
            return ResponseEntity.ok(Map.of("code", 200, "data", Map.of("purchased", purchased)));
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("code", 500, "message", "服务器内部错误: " + e.getMessage()));
        }
    }
    
    // 购买课程
    @PostMapping("/course/purchase")
    public ResponseEntity<?> purchaseCourse(@RequestBody Map<String, Object> requestData, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                return ResponseEntity.status(401).body(Map.of("message", "未提供有效的认证令牌"));
            }
            
            Long userId = jwtUtil.parseUserId(token);
            Student student = studentService.getStudentByUserId(userId);
            if (student == null) {
                return ResponseEntity.status(404).body(Map.of("message", "学生信息未找到"));
            }
            
            // 安全地获取请求参数，增加空值检查
            Object courseIdObj = requestData.get("courseId");
            Object coursePriceObj = requestData.get("coursePrice");
            Object courseNameObj = requestData.get("courseName");
            Object teacherNameObj = requestData.get("teacherName");
            Object coursePicObj = requestData.get("coursePic");
            
            if (courseIdObj == null || coursePriceObj == null || courseNameObj == null || teacherNameObj == null) {
                return ResponseEntity.status(400).body(Map.of("message", "缺少必要的课程信息"));
            }
            
            Long courseId = Long.valueOf(courseIdObj.toString());
            Long coursePrice = Long.valueOf(coursePriceObj.toString());
            String courseName = courseNameObj.toString();
            String teacherName = teacherNameObj.toString();
            String coursePic = coursePicObj != null ? coursePicObj.toString() : "";
            
            boolean success = studentService.purchaseCourse(student.getId(), courseId, coursePrice, courseName, teacherName, coursePic);
            
            if (success) {
                return ResponseEntity.ok(Map.of("message", "购买成功", "success", true));
            } else {
                return ResponseEntity.status(400).body(Map.of("message", "购买失败，可能已经购买过该课程", "success", false));
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "服务器内部错误: " + e.getMessage()));
        }
    }
    
    // 获取购买的课程列表
    @GetMapping("/courses")
    public ResponseEntity<?> getPurchasedCourses(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                return ResponseEntity.status(401).body(Map.of("message", "未提供有效的认证令牌"));
            }
            
            Long userId = jwtUtil.parseUserId(token);
            Student student = studentService.getStudentByUserId(userId);
            if (student == null) {
                return ResponseEntity.status(404).body(Map.of("message", "学生信息未找到"));
            }
            
            List<StudentOrderDetail> purchasedCourses = studentService.getPurchasedCourses(student.getId());
            return ResponseEntity.ok(Map.of("data", purchasedCourses, "total", purchasedCourses.size()));
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "服务器内部错误: " + e.getMessage()));
        }
    }
    
    /**
     * 获取学生的班级列表
     */
    @GetMapping("/student-class/student/{stuId}")
    public ResponseEntity<?> getStudentClasses(@PathVariable Long stuId, HttpServletRequest request) {
        try {
            // 验证JWT token
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                return ResponseEntity.status(401)
                        .body(Map.of("success", false, "message", "未提供有效的认证令牌"));
            }
            
            Long userId = jwtUtil.parseUserId(token);
            
            List<TrainingClass> classes = studentService.getClassesByStudentId(stuId);
            return ResponseEntity.ok(classes);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500)
                    .body(Map.of("success", false, "message", "获取学生班级列表失败"));
        }
    }
    
    /**
     * 获取学生班级的课程列表
     */
    @GetMapping("/student-class/courses/{stuId}")
    public ResponseEntity<?> getStudentClassCourses(@PathVariable Long stuId, HttpServletRequest request) {
        try {
            // 验证JWT token
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                return ResponseEntity.status(401)
                        .body(Map.of("success", false, "message", "未提供有效的认证令牌"));
            }
            
            Long userId = jwtUtil.parseUserId(token);
            
            List<Course> courses = studentService.getClassCoursesByStudentId(stuId);
            return ResponseEntity.ok(courses);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500)
                    .body(Map.of("success", false, "message", "获取学生班级课程列表失败"));
        }
    }
}