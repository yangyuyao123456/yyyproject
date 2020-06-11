package com.yyy.student.controller.DTO;

import lombok.Data;

/**
 * @description: //TODO 学生列表请求对象
 * @author: yuyao.yang
 * @create: 2020/6/12 1:18
 **/
@Data
public class StudentListRequest {
    /**
     * 学生编号
     */
    private String studentNo;

    /**
     * 班级编号
     */
    private String classNo;
    /**
     * 性别
     */
    private Integer sex;

    /**
     * 课程
     */
    private String course;
}
