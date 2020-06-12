package com.yyy.student.entity;

import lombok.Data;

/**
 * @Author: yuyao.yang
 * @Description:  学生类
 * @Date: 0:02 2020/6/12
 * @return:
 **/
@Data
public class Student {
    /**
     * 学生编号
     */
    private String studentNo;

    /**
     * 班级编号
     */
    private String classNo;

    /**
     * 年级编号
     */
    private String gradeNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;


    /**
     * 学生状态
     */
    private Integer studentStatus;

}