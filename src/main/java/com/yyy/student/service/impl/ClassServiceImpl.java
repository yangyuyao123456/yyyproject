package com.yyy.student.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.student.controller.DTO.*;
import com.yyy.student.entity.Class;
import com.yyy.student.entity.Student;
import com.yyy.student.mapper.ClassMapper;
import com.yyy.student.mapper.StudentMapper;
import com.yyy.student.service.ClassService;
import com.yyy.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: //TODO 学生管理实现类
 * @author: yuyao.yang
 * @create: 2020/6/11 23:58
 **/
@Service
@Slf4j
public class ClassServiceImpl implements ClassService {
    @Resource
    private ClassMapper classMapper;
    @Resource
    private StudentMapper studentMapper;

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 班级列表查询
     * @Date: 5:46 2020/6/12
     * @Param: [classRequest]
     * @return: java.util.List<com.yyy.student.controller.DTO.ClassResponse>
     **/
    @Override
    public List<ClassResponse> selectAll() {
        List<Class> classes = classMapper.selectAll();
        List<ClassResponse> list = new ArrayList<>();
        for (Class aClass : classes) {
            ClassResponse classResponse = new ClassResponse();
            if (aClass != null){
                BeanUtils.copyProperties(aClass,classResponse);
                list.add(classResponse);
            }
        }
        if (list.size() == 0){
            log.info("未查询到符合条件的列表");
        }
        log.info("实现类层-班级列表返回对象:{}",list);
        return list;
    }

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 班级查询
     * @Date: 6:00 2020/6/12
     * @Param: [classNo]
     * @return: com.yyy.student.controller.DTO.ClassResponse
     **/
    @Override
    public ClassResponse selectByClassId(Integer classId) {
        log.info("实现类层-班级查询请求对象:{}",classId);
        Class aClass = classMapper.selectByClassId(classId);
        ClassResponse classResponse = new ClassResponse();
        if (aClass != null){
            BeanUtils.copyProperties(aClass,classResponse);
        }else{
            log.info("未查询到对象");
        }
        log.info("实现类层-班级列表返回对象:{}",classResponse);
        return classResponse;
    }

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 班级修改
     * @Date: 6:00 2020/6/12
     * @Param: [classRequest]
     * @return: java.lang.Integer
     **/
    @Override
    public Integer editClass(ClassRequest classRequest) {
        Integer edit = 0;
        log.info("实现类层-班级修改请求对象:{}",classRequest);
        Class aClass = new Class();
        if (classRequest != null){
            BeanUtils.copyProperties(classRequest,aClass);
            //根据classId查询对应的修改前的班级编号
            String classNo = classMapper.selectByClassId(aClass.getClassId()).getClassNo();
            Student student = new Student();
            student.setClassNo(classNo);
            //根据班级编号查询学生列表
            List<Student> students = studentMapper.queryList(student);
            if (students.size()==0){
                edit = classMapper.updateByPrimaryKey(aClass);
            }else{
                log.info("当前班级有学生，不可修改");
            }
        }else{
            log.info("所传对象为空");
        }
        log.info("实现类层-班级修改返回对象:{}",edit);
        return edit;
    }

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 班级新增
     * @Date: 6:00 2020/6/12
     * @Param: [classRequest]
     * @return: java.lang.Integer
     **/
    @Override
    public Integer addClass(ClassRequest classRequest) {
        int insert = 0;
        log.info("实现类层-班级新增请求对象:{}",classRequest);
        Class aClass = new Class();
        if (classRequest != null) {
            BeanUtils.copyProperties(classRequest, aClass);
            classMapper.insert(aClass);
        }else{
            log.info("所传对象为空");
        }
        log.info("实现类层-班级新增返回对象:{}",insert);
        return insert;
    }

    /**
     * @Author: yuyao.yang
     * @Description: //TODO 班级删除
     * @Date: 6:00 2020/6/12
     * @Param: [classId]
     * @return: java.lang.Integer
     **/
    @Override
    public Integer deleteClass(Integer classId) {
        log.info("实现类层-班级删除请求对象:{}",classId);
        //根据classId查询对应的删除前的班级编号
        String classNo = classMapper.selectByClassId(classId).getClassNo();
        Student student = new Student();
        student.setClassNo(classNo);
        //根据班级编号查询学生列表
        Integer i = 0;
        //根据班级编号查询学生列表
        List<Student> students = studentMapper.queryList(student);
        if (students.size()==0){
            i = classMapper.deleteByPrimaryKey(classId);
        }else{
            log.info("当前班级有学生，不可删除");
        }
        log.info("实现类层-班级删除返回对象:{}",i);
        return i;
    }
}
