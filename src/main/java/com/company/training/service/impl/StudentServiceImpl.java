package com.company.training.service.impl;

import com.company.training.entity.Student;
// import com.company.training.entity.vo.StudentQueryVO;
import com.company.training.entity.vo.StudentQueryVO;
import com.company.training.mapper.StudentMapper;
import com.company.training.service.StudentService;
// import com.github.pagehelper.PageHelper;
// import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllActiveStudents() {
        return studentMapper.selectAllActiveStudents();
    }

    // Implement other methods if you build full student CRUD
    @Override
    public PageInfo<Student> getStudentList(StudentQueryVO queryVO) {
        PageHelper.startPage(queryVO.getPageNum(), queryVO.getPageSize());
        List<Student> list = studentMapper.selectByCondition(queryVO);
        return new PageInfo<>(list);
    }

    @Override
    public boolean saveStudent(Student student) {
        // Add validation or business logic if needed
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

}