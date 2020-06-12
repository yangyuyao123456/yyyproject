package com.yyy.student.controller.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:  班级请求对象
 * @author: yuyao.yang
 * @create: 2020/6/12 1:18
 **/
@Data
public class ClassRequest implements Serializable {
    /**
     * 班级主键id
     */
    private String classId;
    /**
     * 班级编号
     */
    private String classNo;
}
