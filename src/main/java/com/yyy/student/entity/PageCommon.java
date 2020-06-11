package com.yyy.student.entity;

import lombok.Data;

import java.util.List;

/**
 * @description: //TODO 分页封装类
 * @author: yuyao.yang
 * @create: 2020/6/12 1:06
 **/
@Data
public class PageCommon<T> {
    /**
     * 返回对象列表
     */
    List<T> tList;

    /**
     * 分页页码
     */
    Integer pageNo;

    /**
     * 分页每页页数
     */
    Integer pageSize;

}
