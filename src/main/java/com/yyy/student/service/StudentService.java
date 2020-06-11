package com.yyy.student.service;

import com.github.pagehelper.PageInfo;
import com.yyy.student.common.Response;
import com.yyy.student.controller.DTO.StudentListResponse;
import com.yyy.student.entity.Student;

import java.util.List;

/**
 * @description: //TODO 学生管理接口
 * @author: yuyao.yang
 * @create: 2020/6/11 23:58
 **/

public interface StudentService {

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 根据条件查询学生列表
     * @Date: 0:34 2020/6/12
     * @Param: [student]
     * @return: com.github.pagehelper.PageInfo<com.yyy.student.entity.Student>
     **/
    PageInfo<StudentListResponse> queryStudentList(int pageNum, int pageSize, Student student);

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 根据学生编号查询学生信息
     * @Date: 0:09 2020/6/12
     * @Param: [studentNo]
     * @return: com.yyy.student.entity.Student
     **/
    Student queryStudent(String studentNo);

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 编辑学生信息
     * @Date: 1:41 2020/6/12
     * @Param: [student]
     * @return: com.yyy.student.common.Response
     **/
    Response editStudent(Student student);

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 新增学生信息
     * @Date: 0:10 2020/6/12
     * @Param: [student]
     * @return: com.yyy.student.common.Response
     **/
    Response addStudent(Student student);

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 删除学生信息
     * @Date: 0:10 2020/6/12
     * @Param: [studentNo]
     * @return: com.yyy.student.common.Response
     **/
    Response deleteStudent(String studentNo);
}
