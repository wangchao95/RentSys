package com.rent.biz;

import com.rent.entity.Type;

import java.util.List;

public interface TypeBiz {

    /**
     * 获得类型集合
     * @return
     */
    List<Type> getTypeList();

}
