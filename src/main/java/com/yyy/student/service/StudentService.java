package com.yyy.student.service;

import com.github.pagehelper.PageInfo;
import com.yyy.student.common.Response;
import com.yyy.student.controller.DTO.StudentListRequest;
import com.yyy.student.controller.DTO.StudentListResponse;
import com.yyy.student.controller.DTO.StudentRequest;
import com.yyy.student.controller.DTO.StudentResponse;
import com.yyy.student.entity.Student;

import java.util.List;

/**
 * @description:  学生管理接口
 * @author: yuyao.yang
 * @create: 2020/6/11 23:58
 **/

public interface StudentService {

    /**
     * @Author: yuyao.yang
     * @Description: 根据条件查询学生列表
     * @Date: 0:34 2020/6/12
     * @Param: [student]
     * @return: com.github.pagehelper.PageInfo<com.yyy.student.entity.Student>
     **/
    PageInfo<StudentListResponse> queryStudentList(StudentListRequest studentRequest);

    /**
     * @Author: yuyao.yang
     * @Description:  根据学生编号查询学生信息
     * @Date: 0:09 2020/6/12
     * @Param: [studentNo]
     * @return: com.yyy.student.entity.Student
     **/
    StudentResponse queryStudent(String studentNo);

    /**
     * @Author: yuyao.yang
     * @Description:  编辑学生信息
     * @Date: 1:41 2020/6/12
     * @Param: [student]
     * @return: java.lang.Integer
     **/
    Integer editStudent(StudentRequest student);

    /**
     * @Author: yuyao.yang
     * @Description:  新增学生信息
     * @Date: 0:10 2020/6/12
     * @Param: [student]
     * @return: java.lang.Integer
     **/
    Integer addStudent(StudentRequest student);

    /**
     * @Author: yuyao.yang
     * @Description:  删除学生信息
     * @Date: 4:15 2020/6/12
     * @Param: [studentNo]
     * @return: java.lang.Integer
     **/
    Integer deleteStudent(String studentNo);
}
