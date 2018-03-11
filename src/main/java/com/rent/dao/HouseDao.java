package com.rent.dao;

import com.rent.entity.House;
import com.rent.entity.Page;
import com.rent.entity.Users;

import java.util.List;

public interface HouseDao {
    /**
     * 添加房屋信息
     * @param house
     */
    void addHouse(House house);

    /**
     * 蝴蝶用户下的租房信息
     * @return
     */
    List<House> getHouseByUser(Users users);


    /**
     * 删除房屋信息
     * @param house
     */
    void deleteHouse(House house);


    /**
     * 根据条件获得每页的集合
     * @return
     */
    List<House> getPageListByParam(House house, Page page);

    /**
     * 获得总的记录数
     * @param house
     * @return
     */
    int getTotalCount(House house);

    /**
     * 通过id获得house
     * @param house
     * @return
     */
    House getHouseByParam(House house);

}
