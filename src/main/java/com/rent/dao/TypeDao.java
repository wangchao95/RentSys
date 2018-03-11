package com.rent.dao;

import com.rent.entity.Type;

import java.util.List;

public interface TypeDao {
    /**
     * 获得列表
     * @return
     */
    List<Type> getTypeList();
}
