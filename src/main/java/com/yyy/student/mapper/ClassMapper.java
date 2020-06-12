package com.yyy.student.mapper;

import com.yyy.student.entity.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    /**
     * 根据班级id删除班级
     * @param classId
     * @return int
     */
    int deleteByPrimaryKey(Integer classId);
    /**
     * 班级新增
     * @param record
     * @return int
     */
    int insert(Class record);
    /**
     * 根据班级id查询班级
     * @param classId
     * @return Class
     */
    Class selectByClassId(Integer classId);
    /**
     * 根据班级号查询班级
     * @param classNo
     * @return Class
     */
    Class selectByClassNo(String classNo);
    /**
     * 班级列表查询
     * @return List<Class>
     */
    List<Class> selectAll();
    /**
     * 班级更新
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Class record);
}