package com.yyy.student.controller;

import com.github.pagehelper.PageInfo;
import com.yyy.student.common.Response;
import com.yyy.student.controller.DTO.StudentListRequest;
import com.yyy.student.controller.DTO.StudentListResponse;
import com.yyy.student.controller.DTO.StudentRequest;
import com.yyy.student.controller.DTO.StudentResponse;
import com.yyy.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.yyy.student.common.Response.*;

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
    @RequestMapping(value = "/queryStudentList", consumes = "application/json",method = RequestMethod.POST)
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
    @RequestMapping(value = "/queryStudent", consumes = "application/json",method = RequestMethod.POST)
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


    @ApiOperation(value="新增学生信息接口", notes="新增学生信息接口")
    @RequestMapping(value = "/addStudent", consumes = "application/json",method = RequestMethod.POST)
    public Response addStudent(@RequestBody StudentRequest studentRequest) {
        Response response = new Response();
        try {
            response = commonReturn(studentService.addStudent(studentRequest));
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="更新学生信息接口", notes="更新学生信息接口")
    @RequestMapping(value = "/editStudent", consumes = "application/json",method = RequestMethod.POST)
    public Response editStudent(@RequestBody StudentRequest studentRequest) {
        Response response = new Response();
        try {
            response = commonReturn(studentService.editStudent(studentRequest));
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="学生离校接口", notes="学生离校接口")
    @RequestMapping(value = "/deleteStudent", consumes = "application/json",method = RequestMethod.POST)
    public Response deleteStudent(@RequestBody String studentNo) {
        Response response = new Response();
        try {
            response = commonReturn(studentService.deleteStudent(studentNo));
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }
}
