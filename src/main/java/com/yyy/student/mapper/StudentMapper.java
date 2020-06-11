package com.yyy.student.mapper;

import com.yyy.student.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yuyao.yang
 * @Description: //TODO 学生Mapper层
 * @Date: 0:47 2020/6/12
 * @Param:
 * @return:
 **/
@Mapper
public interface StudentMapper {
    /**
     * 学生离校
     * @param studentNo
     * @return
     */
    int deleteStudent(@Param("studentNo") String studentNo);

    /**
     * 新增学生信息
     * @param student
     * @return
     */
    int insertStudent(@Param("student") Student student);

    /**
     * 新增课程信息
     * @param student
     * @return
     */
    int insertCourse(@Param("student") Student student);

    /**
     * 根据学生编号查询学生信息
     * @param studentNo
     * @return
     */
    Student selectByStudentNo(@Param("studentNo") String studentNo);

    /**
     * 根据条件查询学生列表
     * @param student
     * @return
     */
    List<Student> queryList(@Param("student") Student student);

    /**
     * 根据学生编号更新学生信息
     * @param student
     * @return
     */
    int updateStudentByStudentNo(@Param("student") Student student);

    /**
     * 根据学生编号更新课程信息
     * @param student
     * @return
     */
    int updateCourseByStudentNo(@Param("student") Student student);
}