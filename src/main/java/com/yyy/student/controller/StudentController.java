package com.yyy.student.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyy.student.common.Response;
import com.yyy.student.controller.DTO.StudentListRequest;
import com.yyy.student.controller.DTO.StudentListResponse;
import com.yyy.student.controller.DTO.StudentResponse;
import com.yyy.student.entity.PageCommon;
import com.yyy.student.entity.Student;
import com.yyy.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.yyy.student.common.Response.failReturn;
import static com.yyy.student.common.Response.successReturn;

/**
 * @description: //TODO 学生管理控制类
 * @author: yuyao.yang
 * @create: 2020/6/11 23:27
 **/
@RestController
@RequestMapping(value = "/student")
@Slf4j
@Api("学生管理控制类")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value="查询学生列表接口", notes="查询学生列表接口")
    @RequestMapping(value = "/queryStudentList", consumes = "application/json")
    public Response queryStudentList(@RequestBody StudentListRequest studentRequest) {
        Response response = new Response();
        try {
            PageInfo<StudentListResponse> studentListResponsePageInfo = studentService.queryStudentList(studentRequest);
            response.setData(studentListResponsePageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="查询学生信息接口", notes="查询学生信息接口")
    @RequestMapping(value = "/queryStudent", consumes = "application/json")
    public Response queryStudent(@RequestBody String studentNo) {
        Response response = new Response();
        try {
            StudentResponse studentResponse = studentService.queryStudent(studentNo);
            response.setData(studentResponse);
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="查询学生列表接口", notes="查询学生列表接口")
    @RequestMapping(value = "/queryStudentList", consumes = "application/json")
    public Response queryStudentList(@RequestBody StudentListRequest studentRequest, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        Response response = new Response();
        try {
            PageInfo<StudentListResponse> studentListResponsePageInfo = studentService.queryStudentList(studentRequest);
            response.setData(studentListResponsePageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="查询学生列表接口", notes="查询学生列表接口")
    @RequestMapping(value = "/queryStudentList", consumes = "application/json")
    public Response queryStudentList(@RequestBody StudentListRequest studentRequest, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        Response response = new Response();
        try {
            PageInfo<StudentListResponse> studentListResponsePageInfo = studentService.queryStudentList(studentRequest);
            response.setData(studentListResponsePageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="查询学生列表接口", notes="查询学生列表接口")
    @RequestMapping(value = "/queryStudentList", consumes = "application/json")
    public Response queryStudentList(@RequestBody StudentListRequest studentRequest, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        Response response = new Response();
        try {
            PageInfo<StudentListResponse> studentListResponsePageInfo = studentService.queryStudentList(studentRequest);
            response.setData(studentListResponsePageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }
}
