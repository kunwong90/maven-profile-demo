package com.env.mapper;

import com.env.entity.Student;

public interface StudentMapper {

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    Student selectOne(Integer id);
}
