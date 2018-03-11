package com.rent.biz;


import com.rent.entity.House;
import com.rent.entity.Page;
import com.rent.entity.Users;

import java.util.List;

public interface HouseBiz {
    /**
     * 添加房屋
     * @param house
     * @return
     */
    int addHouse(House house);

    /**
     * 获得用户下的房屋和用户
     * @param users
     * @return
     */
    List<House> getHouseByUser(Users users);

    /**
     * 删除房屋信息
     * @param house
     * @return
     */
    int removeHouse(House house);

    /**
     * 分页获得详情
     * @param house
     * @param page
     */
    void getPageInfo(House house, Page page);

    /**
     * 通过id获得huose
     * @param id
     * @return
     */
    House getHouseById(int id);

}
