package com.yyy.student.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.student.common.Response;
import com.yyy.student.controller.DTO.StudentListRequest;
import com.yyy.student.controller.DTO.StudentListResponse;
import com.yyy.student.controller.DTO.StudentRequest;
import com.yyy.student.controller.DTO.StudentResponse;
import com.yyy.student.entity.Class;
import com.yyy.student.entity.Student;
import com.yyy.student.mapper.ClassMapper;
import com.yyy.student.mapper.StudentMapper;
import com.yyy.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.yyy.student.common.Response.commonReturn;

/**
 * @description:  学生管理实现类
 * @author: yuyao.yang
 * @create: 2020/6/11 23:58
 **/
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private ClassMapper classMapper;
    /**
     * @Author: yuyao.yang
     * @Description:  根据条件查询学生列表
     * @Date: 3:32 2020/6/12
     * @Param: [studentRequest]
     * @return: com.github.pagehelper.PageInfo<com.yyy.student.controller.DTO.StudentListResponse>
     **/
    @Override
    public PageInfo<StudentListResponse> queryStudentList(StudentListRequest studentRequest) {
        log.info("实现类层-学生列表请求对象:{}",studentRequest);
        Integer pageNo = studentRequest.getPageNo();
        log.info("分页页码:{}",pageNo);
        Integer pageSize = studentRequest.getPageSize();
        log.info("分页每页条数:{}",pageSize);
        Student student = new Student();
        BeanUtils.copyProperties(studentRequest,student);
        log.info("查询条件对象:{}",student);
        //开启分页
        //对mapper列表查询进行分页处理，查询每页pageSize条时第pageNo页的数据列表
        PageHelper.startPage(pageNo, pageSize);
        List<Student> studentSelectList = studentMapper.queryList(student);
        log.info("查询列表:{}",studentSelectList);
        //初始化返回对象列表
        List<StudentListResponse> responseList = new ArrayList<>();
        for (Student student1 : studentSelectList) {
            StudentListResponse listStudent = new StudentListResponse();
            //将查询出的列表对象复制给返回对象
            BeanUtils.copyProperties(student1,listStudent);
            //将返回对象添加到返回对象列表中
            responseList.add(listStudent);
        }
        log.info("复制后的返回列表:{}",responseList);
        //初始化查询对象列表第pageNo页的PageInfo对象
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentSelectList, pageNo);
        //初始化返回对象列表第pageNo页的PageInfo对象
        PageInfo<StudentListResponse> studentResPage = new PageInfo<>(responseList,pageNo);
        //将对象列表PageInfo对象的总页数和总条数设置给返回对象列表的PageInfo对象
        studentResPage.setPages(studentPageInfo.getPages());
        studentResPage.setTotal(studentPageInfo.getTotal());
        log.info("实现类层-学生列表响应对象:{}",studentResPage);
        return studentResPage;
    }

    /**
     * @Author: yuyao.yang
     * @Description:  根据学生编号查询学生信息
     * @Date: 0:55 2020/6/12
     * @Param: [studentNo]
     * @return: com.yyy.student.entity.Student
     **/
    @Override
    public StudentResponse queryStudent(String studentNo) {
        log.info("实现类层-学生信息请求对象:{}",studentNo);
        //初始化学生信息返回对象
        StudentResponse studentResponse = new StudentResponse();
        Student student = studentMapper.selectByStudentNo(studentNo);
        if (student!=null){
            BeanUtils.copyProperties(student,studentResponse);
            log.info("实现类层-学生信息响应对象:{}",studentResponse);
        }
        return studentResponse;
    }

    /**
     * @Author: yuyao.yang
     * @Description: 根据学生编号更新学生信息
     * @Date: 4:15 2020/6/12
     * @Param: [studentRequest]
     * @return: java.lang.Integer
     **/
    @Override
    @Transactional
    public Integer editStudent(StudentRequest studentRequest) {
        Integer i = 0;
        log.info("实现类层-更新学生信息请求对象:{}",studentRequest);
        if (!StringUtils.isEmpty(studentRequest.getClassNo())){
            String classNo = studentRequest.getClassNo();
            Class aClass = classMapper.selectByClassNo(classNo);
            if (null != aClass){
                Student student = new Student();
                BeanUtils.copyProperties(studentRequest,student);
                i = studentMapper.updateStudentByStudentNo(student);
            }else{
                log.info("更新学生失败，指定班级不存在");
            }
        }
        log.info("实现类层-更新学生信息返回对象:{}",i);
        return i;
    }

    /**
     * @Author: yuyao.yang
     * @Description:  新增学生信息
     * @Date: 4:15 2020/6/12
     * @Param: [studentRequest]
     * @return: java.lang.Integer
     **/
    @Override
    @Transactional
    public Integer addStudent(StudentRequest studentRequest) {
        Integer i = 0;
        log.info("实现类层-新增学生信息请求对象:{}",studentRequest);
        if (StringUtils.isEmpty(studentRequest.getClassNo())){
            String classNo = studentRequest.getClassNo();
            Class aClass = classMapper.selectByClassNo(classNo);
            if (null != aClass){
                Student student = new Student();
                BeanUtils.copyProperties(studentRequest,student);
                i = studentMapper.insertStudent(student);
            }else{
                log.info("新增学生失败，指定班级不存在");
            }
        }
        log.info("实现类层-新增学生信息返回对象:{}",i);
        return i;
    }

    /**
     * @Author: yuyao.yang
     * @Description:  学生离校
     * @Date: 4:15 2020/6/12
     * @Param: [studentNo]
     * @return: java.lang.Integer
     **/
    @Override
    public Integer deleteStudent(String studentNo) {
        log.info("实现类层-更新学生信息请求对象:{}",studentNo);
        Integer i = studentMapper.deleteStudent(studentNo);
        log.info("实现类层-更新学生信息返回对象:{}",i);
        return i;
    }
}
