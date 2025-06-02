package com.company.training.service.impl;

import com.company.training.entity.Student;
import com.company.training.entity.StudentClass;
import com.company.training.entity.CourseClass;
import com.company.training.entity.TrainingClass;
import com.company.training.entity.vo.ClassQueryVO;
import com.company.training.mapper.TrainingClassMapper;
import com.company.training.mapper.StudentClassMapper;
import com.company.training.mapper.CourseClassMapper;
import com.company.training.mapper.StudentMapper; // Assuming you have this
import com.company.training.service.TrainingClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.training.entity.vo.CourseVO; // <--- 引入

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingClassServiceImpl implements TrainingClassService {

    @Autowired
    private TrainingClassMapper trainingClassMapper;

    @Autowired
    private StudentClassMapper studentClassMapper;

    @Autowired
    private CourseClassMapper courseClassMapper;

    @Autowired
    private StudentMapper studentMapper; // For fetching all students

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
        // Check if already exists to prevent duplicates if DB constraint is not there
        StudentClass sc = new StudentClass();
        sc.setClassId(classId);
        sc.setStuId(studentId);
        int inserted = studentClassMapper.insert(sc);
        if (inserted > 0) {
            trainingClassMapper.updateStudentCount(classId, 1);
            return true;
        }
        return false;
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
        CourseClass cc = new CourseClass();
        cc.setClassId(classId);
        cc.setCouId(courseId);
        return courseClassMapper.insert(cc) > 0;
    }

    @Override
    @Transactional
    public boolean removeCourseFromClass(Long classId, Long courseId) {
        return courseClassMapper.deleteByClassIdAndCourseId(classId, courseId) > 0;
    }
}