package com.rent.biz;

import com.rent.entity.District;
import com.rent.entity.Street;

import java.util.List;

public interface StreetBiz{


    /**
     * 获得街道列表
     * @return
     */
    List<Street> getStreets(District district);
}
