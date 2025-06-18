package com.company.training.service.impl;

import com.company.training.entity.Student;
import com.company.training.entity.StudentClass;
import com.company.training.entity.CourseClass;
import com.company.training.entity.TrainingClass;
import com.company.training.entity.Course;
import com.company.training.entity.StudentOrder;
import com.company.training.entity.StudentOrderDetail;
import com.company.training.entity.vo.ClassQueryVO;
import com.company.training.mapper.TrainingClassMapper;
import com.company.training.mapper.StudentClassMapper;
import com.company.training.mapper.CourseClassMapper;
import com.company.training.mapper.StudentMapper;
import com.company.training.mapper.CourseMapper;
import com.company.training.mapper.StudentOrderMapper;
import com.company.training.service.TrainingClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.training.entity.vo.CourseVO;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TrainingClassServiceImpl implements TrainingClassService {

    @Autowired
    private TrainingClassMapper trainingClassMapper;

    @Autowired
    private StudentClassMapper studentClassMapper;

    @Autowired
    private CourseClassMapper courseClassMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentOrderMapper studentOrderMapper;

    // == Class Info Management ==
    @Override
    @Transactional
    public boolean saveClass(TrainingClass trainingClass) {
        trainingClass.setClassStuNum(0); // Initialize student count
        return trainingClassMapper.insert(trainingClass) > 0;
    }

    @Override
    @Transactional
    public boolean updateClass(TrainingClass trainingClass) {
        // Student count should ideally be updated via add/remove student methods
        return trainingClassMapper.updateByPrimaryKey(trainingClass) > 0;
    }

    @Override
    @Transactional
    public boolean deleteClass(Long id) {
        // Optionally, also remove associations in student_class and course_class
         studentClassMapper.deleteByClassId(id);
         courseClassMapper.deleteByClassId(id);
        return trainingClassMapper.logicalDeleteByPrimaryKey(id) > 0;
    }

    @Override
    public TrainingClass getClassById(Long id) {
        return trainingClassMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<TrainingClass> getClassList(ClassQueryVO queryVO) {
        PageHelper.startPage(queryVO.getPageNum(), queryVO.getPageSize());
        List<TrainingClass> list = trainingClassMapper.selectByCondition(queryVO);
        return new PageInfo<>(list);
    }

    @Override
    public List<TrainingClass> getAllClasses() {
        return trainingClassMapper.selectAll();
    }


    // == Class Student Management ==
    @Override
    public List<Student> getStudentsByClassId(Long classId) {
        List<Student> students = studentClassMapper.findStudentsByClassId(classId);
        System.out.println("DEBUG: Fetched students from studentClassMapper for classId " + classId + ": " + students);
        // 打印每个学生的stuName
        if (students != null) {
            students.forEach(s -> System.out.println("DEBUG: Student ID: " + s.getId() + ", Name: " + s.getStuName()));
        }
        return students;
    }

    @Override
    public List<Student> getAvailableStudentsForClass(Long classId) {
        List<Student> allStudents = studentMapper.selectAllActiveStudents(); // You'd need this method in StudentMapper
        List<Student> studentsInClass = studentClassMapper.findStudentsByClassId(classId);
        List<Long> studentIdsInClass = studentsInClass.stream().map(Student::getId).collect(Collectors.toList());
        return allStudents.stream()
                .filter(student -> !studentIdsInClass.contains(student.getId()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean addStudentToClass(Long classId, Long studentId) {
        try {
            // 1. 添加学生到班级
            StudentClass sc = new StudentClass();
            sc.setClassId(classId);
            sc.setStuId(studentId);
            int inserted = studentClassMapper.insert(sc);
            if (inserted <= 0) {
                return false;
            }
            
            // 2. 更新班级学生数量
            trainingClassMapper.updateStudentCount(classId, 1);
            
            // 3. 获取班级中的所有课程
            List<CourseVO> courses = courseClassMapper.getCoursesByClassId(classId);
            
            // 4. 为该学生创建所有班级课程的购买记录
            for (CourseVO courseVO : courses) {
                Long courseId = courseVO.getId();
                
                // 检查学生是否已经购买了该课程
                StudentOrderDetail existingOrder = studentOrderMapper.selectOrderDetailByStuIdAndCourseId(studentId, courseId);
                if (existingOrder != null) {
                    continue; // 已经购买过，跳过
                }
                
                // 获取完整的课程信息
                Course course = courseMapper.selectByPrimaryKey(courseId);
                if (course == null) {
                    continue;
                }
                
                // 创建订单
                StudentOrder order = new StudentOrder();
                order.setCode("CLASS_" + System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 8));
                order.setStuId(studentId);
                order.setAmount(course.getCouPrice() != null ? course.getCouPrice().longValue() : 0L);
                order.setCreateTime(LocalDateTime.now());
                order.setUpdateTime(LocalDateTime.now());
                order.setDeleted(0);
                
                int orderResult = studentOrderMapper.insert(order);
                if (orderResult <= 0) {
                    continue; // 订单创建失败，跳过该课程
                }
                
                // 创建订单详情
                StudentOrderDetail orderDetail = new StudentOrderDetail();
                orderDetail.setOrderId(order.getId());
                orderDetail.setCouId(courseId);
                orderDetail.setCouPrice(course.getCouPrice() != null ? course.getCouPrice().longValue() : 0L);
                orderDetail.setCouPic(course.getCouPic());
                orderDetail.setTeaName("教师"); // 可以根据需要获取教师姓名
                orderDetail.setCouName(course.getCouName());
                orderDetail.setCreateTime(LocalDateTime.now());
                orderDetail.setUpdateTime(LocalDateTime.now());
                orderDetail.setDeleted(0);
                
                studentOrderMapper.insertOrderDetail(orderDetail);
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加学生到班级失败", e);
        }
    }

    @Override
    @Transactional
    public boolean removeStudentFromClass(Long classId, Long studentId) {
        int deleted = studentClassMapper.delete(classId, studentId);
        if (deleted > 0) {
            trainingClassMapper.updateStudentCount(classId, -1);
            return true;
        }
        return false;
    }

    // == Class Course Management ==
    @Override
    public List<CourseVO> getCoursesByClassId(Long classId) {
        List<CourseVO> courses = courseClassMapper.getCoursesByClassId(classId);
        System.out.println("DEBUG: Fetched courses from courseClassMapper for classId " + classId + ": " + courses);
        // 打印每个课程的couName和teaName
        if (courses != null) {
            courses.forEach(c -> System.out.println("DEBUG: Course ID: " + c.getId() + ", Course Name: " + c.getCouName() + ", Teacher Name: " + c.getTeaName()));
        }
        return courses;
    }

    @Override
    public List<CourseVO> getAvailableCoursesForClass(Long classId) {
        // 确保 courseClassMapper.getAvailableCoursesForClass 也返回 List<CourseVO>
        // 如果您在 CourseClassMapper.xml 中没有为 getAvailableCoursesForClass 实现 JOIN Teacher 的 SQL,
        // 那么这里就需要更复杂的处理：
        // 1. 获取所有课程的 CourseVO 列表 (这意味着 CourseMapper.selectByCondition 也需要能返回 CourseVO)
        // 2. 获取已分配给班级的课程ID
        // 3. 过滤
        // 为了简单和一致性，强烈建议 CourseClassMapper.xml 中的 getAvailableCoursesForClass 查询也JOIN teacher表
        // 并将 CourseClassMapper.java 中该方法的返回类型也改为 List<CourseVO>

        // 假设 CourseClassMapper.getAvailableCoursesForClass 已经修改为返回 List<CourseVO>
        return courseClassMapper.getAvailableCoursesForClass(classId);
    }

    @Override
    @Transactional
    public boolean addCourseToClass(Long classId, Long courseId) {
        try {
            // 1. 添加课程到班级
            CourseClass cc = new CourseClass();
            cc.setClassId(classId);
            cc.setCouId(courseId);
            int result = courseClassMapper.insert(cc);
            if (result <= 0) {
                return false;
            }
            
            // 2. 获取课程信息
            Course course = courseMapper.selectByPrimaryKey(courseId);
            if (course == null) {
                return false;
            }
            
            // 3. 获取班级中的所有学生
            List<Student> students = studentClassMapper.findStudentsByClassId(classId);
            
            // 4. 为每个学生创建购买记录
            for (Student student : students) {
                // 检查学生是否已经购买了该课程
                StudentOrderDetail existingOrder = studentOrderMapper.selectOrderDetailByStuIdAndCourseId(student.getId(), courseId);
                if (existingOrder != null) {
                    continue; // 已经购买过，跳过
                }
                
                // 创建订单
                StudentOrder order = new StudentOrder();
                order.setCode("CLASS_" + System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 8));
                order.setStuId(student.getId());
                order.setAmount(course.getCouPrice() != null ? course.getCouPrice().longValue() : 0L);
                order.setCreateTime(LocalDateTime.now());
                order.setUpdateTime(LocalDateTime.now());
                order.setDeleted(0);
                
                int orderResult = studentOrderMapper.insert(order);
                if (orderResult <= 0) {
                    continue; // 订单创建失败，跳过该学生
                }
                
                // 创建订单详情
                StudentOrderDetail orderDetail = new StudentOrderDetail();
                orderDetail.setOrderId(order.getId());
                orderDetail.setCouId(courseId);
                orderDetail.setCouPrice(course.getCouPrice() != null ? course.getCouPrice().longValue() : 0L);
                orderDetail.setCouPic(course.getCouPic());
                orderDetail.setTeaName("教师"); // 可以根据需要获取教师姓名
                orderDetail.setCouName(course.getCouName());
                orderDetail.setCreateTime(LocalDateTime.now());
                orderDetail.setUpdateTime(LocalDateTime.now());
                orderDetail.setDeleted(0);
                
                studentOrderMapper.insertOrderDetail(orderDetail);
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加课程到班级失败", e);
        }
    }

    @Override
    @Transactional
    public boolean removeCourseFromClass(Long classId, Long courseId) {
        return courseClassMapper.deleteByClassIdAndCourseId(classId, courseId) > 0;
    }
}