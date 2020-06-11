package com.yyy.student.entity;

import lombok.Data;

/**
 * @Author: yuyao.yang
 * @Description: //TODO 学生类
 * @Date: 0:02 2020/6/12
 * @Param:
 * @return:
 **/
@Data
public class Student {
    /**
     * 学生主键
     */
    private Integer studentId;

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
     * 课程
     */
    private String course;

    /**
     * 成绩
     */
    private Integer success;

    /**
     * 是否及格
     */
    private Boolean pass;

    /**
     * 学生状态
     */
    private Integer studentStatus;

}