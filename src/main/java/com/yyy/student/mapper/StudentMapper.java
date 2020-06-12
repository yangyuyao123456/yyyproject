package com.yyy.student.mapper;

import com.yyy.student.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yuyao.yang
 * @Description:  学生Mapper层
 * @Date: 0:47 2020/6/12
 **/
@Mapper
public interface StudentMapper {
    /**
     * 学生离校
     * @param studentNo
     * @return int
     */
    int deleteStudent(@Param("studentNo") String studentNo);

    /**
     * 新增学生信息
     * @param student
     * @return int
     */
    int insertStudent(@Param("student") Student student);

    /**
     * 根据学生编号查询学生信息
     * @param studentNo
     * @return Student
     */
    Student selectByStudentNo(@Param("studentNo") String studentNo);

    /**
     * 根据条件查询学生列表
     * @param student
     * @return List<Student>
     */
    List<Student> queryList(@Param("student") Student student);

    /**
     * 根据学生编号更新学生信息
     * @param student
     * @return int
     */
    int updateStudentByStudentNo(@Param("student") Student student);

}