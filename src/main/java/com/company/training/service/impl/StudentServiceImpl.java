package com.company.training.service.impl;

import com.company.training.entity.Student;
import com.company.training.entity.StudentOrder;
import com.company.training.entity.StudentOrderDetail;
import com.company.training.entity.TrainingClass;
import com.company.training.entity.Course;
import com.company.training.entity.vo.StudentQueryVO;
import com.company.training.mapper.StudentMapper;
import com.company.training.mapper.StudentOrderMapper;
import com.company.training.mapper.StudentClassMapper;
import com.company.training.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    
    @Autowired
    private StudentOrderMapper studentOrderMapper;
    
    @Autowired
    private StudentClassMapper studentClassMapper;

    @Override
    public List<Student> getAllActiveStudents() {
        return studentMapper.selectAllActiveStudents();
    }

    @Override
    public PageInfo<Student> getStudentList(StudentQueryVO queryVO) {
        PageHelper.startPage(queryVO.getPageNum(), queryVO.getPageSize());
        List<Student> list = studentMapper.selectByCondition(queryVO);
        return new PageInfo<>(list);
    }

    @Override
    public boolean saveStudent(Student student) {
        return studentMapper.insert(student) > 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateByPrimaryKey(student) > 0;
    }

    @Override
    public boolean deleteStudent(Long id) {
        return studentMapper.logicalDeleteByPrimaryKey(id) > 0;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Student getStudentByUserId(Long userId) {
        return studentMapper.findByUserId(userId);
    }

    @Override
    public boolean checkCoursePurchased(Long stuId, Long courseId) {
        StudentOrderDetail orderDetail = studentOrderMapper.selectOrderDetailByStuIdAndCourseId(stuId, courseId);
        return orderDetail != null;
    }

    @Override
    @Transactional
    public boolean purchaseCourse(Long stuId, Long courseId, Long coursePrice, String courseName, String teacherName, String coursePic) {
        try {
            // 检查是否已经购买
            if (checkCoursePurchased(stuId, courseId)) {
                return false;
            }
            
            // 获取学生信息并检查积分
            Student student = studentMapper.selectByPrimaryKey(stuId);
            // 价格转换为积分：1元 = 10积分
            Long pointsRequired = coursePrice * 10;
            if (student == null || student.getStuScore() < pointsRequired) {
                return false; // 积分不足
            }
            
            // 扣除积分
            student.setStuScore(student.getStuScore() - pointsRequired);
            int updateResult = studentMapper.updateByPrimaryKey(student);
            if (updateResult <= 0) {
                return false;
            }
            
            // 创建订单
            StudentOrder order = new StudentOrder();
            order.setCode("ORDER_" + System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 8));
            order.setStuId(stuId);
            order.setAmount(coursePrice); // 存储实际课程价格
            
            int orderResult = studentOrderMapper.insert(order);
            if (orderResult <= 0) {
                return false;
            }
            
            // 创建订单详情
            StudentOrderDetail orderDetail = new StudentOrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setCouId(courseId);
            orderDetail.setCouPrice(coursePrice);
            orderDetail.setCouName(courseName);
            orderDetail.setTeaName(teacherName);
            orderDetail.setCouPic(coursePic);
            
            int detailResult = studentOrderMapper.insertOrderDetail(orderDetail);
            return detailResult > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<StudentOrderDetail> getPurchasedCourses(Long stuId) {
        return studentOrderMapper.selectPurchasedCoursesByStuId(stuId);
    }
    
    @Override
    @Transactional
    public boolean performCheckin(Long stuId) {
        try {
            // 检查今日是否已签到
            if (!canCheckinToday(stuId)) {
                return false;
            }
            
            // 获取学生信息
            Student student = studentMapper.selectByPrimaryKey(stuId);
            if (student == null) {
                return false;
            }
            
            // 增加10积分
            addPoints(stuId, 10L);
            
            // 更新签到记录（这里简化处理，实际项目中可能需要专门的签到记录表）
            // 暂时使用updateTime字段来记录最后签到时间
            student.setUpdateTime(LocalDateTime.now());
            int result = studentMapper.updateByPrimaryKey(student);
            
            return result > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean canCheckinToday(Long stuId) {
        try {
            Student student = studentMapper.selectByPrimaryKey(stuId);
            if (student == null) {
                return false;
            }
            
            // 检查最后更新时间是否为今天（简化处理）
            LocalDateTime lastUpdate = student.getUpdateTime();
            if (lastUpdate == null) {
                return true;
            }
            
            LocalDate today = LocalDate.now();
            LocalDate lastUpdateDate = lastUpdate.toLocalDate();
            
            // 如果最后更新不是今天，则可以签到
            return !today.equals(lastUpdateDate);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    @Transactional
    public void addPoints(Long stuId, Long points) {
        try {
            Student student = studentMapper.selectByPrimaryKey(stuId);
            if (student != null) {
                Long currentScore = student.getStuScore() != null ? student.getStuScore() : 0L;
                student.setStuScore(currentScore + points);
                studentMapper.updateByPrimaryKey(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<TrainingClass> getClassesByStudentId(Long studentId) {
        try {
            return studentClassMapper.findClassesByStudentId(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
    
    @Override
    public List<Course> getClassCoursesByStudentId(Long studentId) {
        try {
            return studentClassMapper.findClassCoursesByStudentId(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}