package com.company.training.service.impl;

import com.company.training.entity.Student;
import com.company.training.entity.StudentOrder;
import com.company.training.entity.StudentOrderDetail;
import com.company.training.entity.vo.StudentQueryVO;
import com.company.training.mapper.StudentMapper;
import com.company.training.mapper.StudentOrderMapper;
import com.company.training.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    
    @Autowired
    private StudentOrderMapper studentOrderMapper;

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
            if (student == null || student.getStuScore() < coursePrice) {
                return false; // 积分不足
            }
            
            // 扣除积分
            student.setStuScore(student.getStuScore() - coursePrice);
            int updateResult = studentMapper.updateByPrimaryKey(student);
            if (updateResult <= 0) {
                return false;
            }
            
            // 创建订单
            StudentOrder order = new StudentOrder();
            order.setCode("ORDER_" + System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 8));
            order.setStuId(stuId);
            order.setAmount(coursePrice);
            
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
}