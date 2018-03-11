package com.rent.dao;

import com.rent.entity.District;
import com.rent.entity.Street;

import java.util.List;

public interface StreetDao {

    /**
     * 获得街道列表
     * @return
     */
    List<Street> getStreetList(District district);
}
