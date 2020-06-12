package com.yyy.student.controller;

import com.github.pagehelper.PageInfo;
import com.yyy.student.common.Response;
import com.yyy.student.controller.DTO.*;
import com.yyy.student.service.ClassService;
import com.yyy.student.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yyy.student.common.Response.*;

/**
 * @description: 班级管理控制类
 * @author: yuyao.yang
 * @create: 2020/6/12 06:01
 **/
@RestController
@RequestMapping(value = "/class")
@Slf4j
@Api("班级管理控制类")
public class ClassController {
    @Autowired
    private ClassService classService;

    @ApiOperation(value="查询班级列表接口", notes="查询班级列表接口")
    @RequestMapping(value = "/queryClassList", consumes = "application/json" ,method = RequestMethod.POST)
    public Response queryClassList() {
        Response response = new Response();
        try {
            List<ClassResponse> list = classService.selectAll();
            response.setData(list);
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="查询班级接口", notes="查询班级接口")
    @RequestMapping(value = "/queryClass", consumes = "application/json",method = RequestMethod.POST)
    public Response queryClass(@RequestBody Integer classId) {
        Response response = new Response();
        try {
            ClassResponse classResponse = classService.selectByClassId(classId);
            response.setData(classResponse);
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="新增班级接口", notes="新增班级信息接口")
    @RequestMapping(value = "/addClass", consumes = "application/json",method = RequestMethod.POST)
    public Response addClass(@RequestBody ClassRequest classRequest) {
        Response response = new Response();
        try {
            response = commonReturn(classService.addClass(classRequest));
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="更新班级信息接口", notes="更新班级信息接口")
    @RequestMapping(value = "/editClass", consumes = "application/json",method = RequestMethod.POST)
    public Response editClass(@RequestBody ClassRequest classRequest) {
        Response response = new Response();
        try {
            response = commonReturn(classService.editClass(classRequest));
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }


    @ApiOperation(value="删除班级接口", notes="删除班级接口")
    @RequestMapping(value = "/deleteStudent", consumes = "application/json",method = RequestMethod.POST)
    public Response deleteClass(@RequestBody Integer classId) {
        Response response = new Response();
        try {
            response = commonReturn(classService.deleteClass(classId));
        }catch (Exception e){
            e.printStackTrace();
            return failReturn(response);
        }
        return successReturn(response);
    }
}
