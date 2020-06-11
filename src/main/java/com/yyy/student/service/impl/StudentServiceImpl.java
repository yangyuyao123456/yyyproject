package com.yyy.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.student.common.Response;
import com.yyy.student.controller.DTO.StudentListResponse;
import com.yyy.student.entity.Student;
import com.yyy.student.mapper.StudentMapper;
import com.yyy.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.yyy.student.common.Response.commonReturn;

/**
 * @description: //TODO 学生管理实现类
 * @author: yuyao.yang
 * @create: 2020/6/11 23:58
 **/
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 根据条件查询学生列表
     * @Date: 0:35 2020/6/12
     * @Param: [pageNum, pageSize, student]
     * @param student classNo班级号
     *                studentNo学生号
     *                sex 性别 0男 1女
     *                course 课程
     *                pass 是否及格 true及格 false不及格
     * @return: com.github.pagehelper.PageInfo<com.yyy.student.entity.Student>
     **/
    @Override
    public PageInfo<StudentListResponse> queryStudentList(int pageNo, int pageSize, Student student) {
        PageHelper.startPage(pageNo, pageSize);
        List<Student> studentSelectList = studentMapper.queryList(student);
        List<StudentListResponse> responseList = new ArrayList<>();
        for (Student student1 : studentSelectList) {
            StudentListResponse listStudent = new StudentListResponse();
            BeanUtils.copyProperties(student1,listStudent);
            responseList.add(listStudent);
        }
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentSelectList, pageSize);
        PageInfo<StudentListResponse> studentResPage = new PageInfo<>(responseList,pageSize);
        studentResPage.setPages(studentPageInfo.getPages());
        studentResPage.setTotal(studentPageInfo.getTotal());
        studentResPage.setPageNum(pageNo);
        return studentResPage;
    }

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 根据学生编号查询学生信息
     * @Date: 0:55 2020/6/12
     * @Param: [student]
     * @return: com.yyy.student.entity.Student
     **/
    @Override
    public Student queryStudent(String studentNo) {
        return studentMapper.selectByStudentNo(studentNo);
    }

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 根据学生编号更新学生信息
     * @Date: 1:02 2020/6/12
     * @Param: [student]
     * @return: void
     **/
    @Override
    public Response editStudent(Student student) {
        return commonReturn(studentMapper.updateByStudentNo(student));
    }

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 新增学生信息
     * @Date: 1:02 2020/6/12
     * @Param: [student]
     * @return: void
     **/
    @Override
    public Response addStudent(Student student) {
       return commonReturn(studentMapper.insert(student));
    }

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 学生离校
     * @Date: 1:02 2020/6/12
     * @Param: [studentNo]
     * @return: void
     **/
    @Override
    public Response deleteStudent(String studentNo) {
        return commonReturn(studentMapper.deleteStudent(studentNo));
    }
}
