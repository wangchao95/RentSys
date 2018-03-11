package com.rent.dao;

import com.rent.entity.District;

import java.util.List;

public interface DistrictDao  {

    /**
     * 获得列表
     * @return
     */
    List<District> getDistrictList();
}
