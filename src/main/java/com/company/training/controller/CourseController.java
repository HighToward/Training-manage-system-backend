package com.company.training.controller;

import com.company.training.entity.Course;
import com.company.training.entity.CourseType;
import com.company.training.entity.Student;
import com.company.training.entity.vo.CourseQueryVO;
import com.company.training.entity.vo.CourseVO;
import com.company.training.entity.vo.Result;
import com.company.training.service.CourseService;
import com.company.training.service.StudentCourseCollectionService;
import com.company.training.service.StudentCourseFancyService;
import com.company.training.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StudentCourseCollectionService collectionService;
    
    @Autowired
    private StudentCourseFancyService fancyService;

    @GetMapping("/list")
    public Result<PageInfo<CourseVO>> getCourseList(CourseQueryVO queryVO) {
        PageInfo<CourseVO> pageInfo = courseService.getCourseList(queryVO);
        return Result.success(pageInfo);
    }

    @GetMapping("/{id}")
    public Result<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return Result.success(course);
    }

    @PostMapping
    public Result<Boolean> saveCourse(@RequestBody Course course) {
        boolean success = courseService.saveCourse(course);
        return success ? Result.success(true) : Result.error("保存失败");
    }

    @PutMapping
    public Result<Boolean> updateCourse(@RequestBody Course course) {
        boolean success = courseService.updateCourse(course);
        return success ? Result.success(true) : Result.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteCourse(@PathVariable Long id) {
        boolean success = courseService.deleteCourse(id);
        return success ? Result.success(true) : Result.error("删除失败");
    }

    @GetMapping("/types")
    public Result<List<CourseType>> getCourseTypeTree() {
        List<CourseType> typeTree = courseService.getCourseTypeTree();
        return Result.success(typeTree);
    }
    
    /**
     * 获取课程详情页信息（包含学生积分、收藏状态、点赞状态等）
     */
    @GetMapping("/detail/{courseId}")
    public Result getCourseDetailInfo(@PathVariable Long courseId, @RequestParam Long stuId) {
        try {
            // 获取课程信息
            Course course = courseService.getCourseById(courseId);
            if (course == null) {
                return Result.error("课程不存在");
            }
            
            // 获取学生信息（积分）
            Student student = studentService.getStudentById(stuId);
            if (student == null) {
                return Result.error("学生不存在");
            }
            
            // 检查收藏状态
            Result collectionResult = collectionService.checkCollectionStatus(stuId, courseId);
            boolean isCollected = collectionResult.getCode() == 200 && (Boolean) collectionResult.getData();
            
            // 检查点赞状态
            Result fancyResult = fancyService.checkFancyStatus(stuId, courseId);
            boolean isFancied = fancyResult.getCode() == 200 && (Boolean) fancyResult.getData();
            
            // 获取点赞数量
            Result fancyCountResult = fancyService.getFancyCountByCouId(courseId);
            int fancyCount = fancyCountResult.getCode() == 200 ? (Integer) fancyCountResult.getData() : 0;
            
            // 获取收藏数量
            Result collectionCountResult = collectionService.getCollectionCountByCouId(courseId);
            int collectionCount = collectionCountResult.getCode() == 200 ? (Integer) collectionCountResult.getData() : 0;
            
            // 组装返回数据
            java.util.Map<String, Object> detailInfo = new java.util.HashMap<>();
            detailInfo.put("course", course);
            detailInfo.put("studentPoints", student.getStuScore());
            detailInfo.put("requiredPoints", course.getCouPrice());
            detailInfo.put("isCollected", isCollected);
            detailInfo.put("isFancied", isFancied);
            detailInfo.put("fancyCount", fancyCount);
            detailInfo.put("collectionCount", collectionCount);
            
            return Result.success(detailInfo);
            
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取课程详情失败：" + e.getMessage());
        }
    }
}