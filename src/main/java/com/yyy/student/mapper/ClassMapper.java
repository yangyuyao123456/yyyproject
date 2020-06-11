package com.yyy.student.mapper;

import com.yyy.student.entity.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(Class record);

    Class selectByClassId(Integer classId);

    Class selectByClassNo(String classNo);

    List<Class> selectAll();

    int updateByPrimaryKey(Class record);
}