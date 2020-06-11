package com.yyy.student.controller.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: //TODO 班级响应对象
 * @author: yuyao.yang
 * @create: 2020/6/12 1:19
 **/
@Data
public class ClassResponse implements Serializable {
    /**
     * 班级主键id
     */
    private String classId;
    /**
     * 班级编号
     */
    private String classNo;
}
