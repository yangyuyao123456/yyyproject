package com.yyy.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.student.entity.PageCommon;
import com.yyy.student.entity.Student;
import com.yyy.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: //TODO 学生管理控制类
 * @author: yuyao.yang
 * @create: 2020/6/11 23:27
 **/
@RestController
@RequestMapping(value = "/student")
@Slf4j
@Api(description = "学生管理控制类")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public PageInfo<Student> queryStudentList(PageCommon<Student> studentPage) {
        Integer pageNo = studentPage.getPageNo();
        log.info("分页页码:{}",pageNo);
        Integer pageSize = studentPage.getPageSize();
        log.info("分页每页条数:{}",pageSize);
        studentService.queryStudentList();
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList, pageSize);
        return studentPageInfo;
    }
    @ApiOperation(value="平盘交易接口", notes="平盘交易接口")
    @RequestMapping(value = "/traderOrder", consumes = "application/json")
    public String tradeRequest(@RequestBody String jsonReq) {
        String jsonRep = channelService.tradeRequest(jsonReq);
        return jsonRep;
    }
}
