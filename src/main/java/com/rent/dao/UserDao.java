package com.rent.dao;

import com.rent.entity.Users;

import java.util.List;

/**
 * 用户dao接口
 */
public interface UserDao {

    /**
     * 按条件查询用户对象
     * @param users
     * @return
     */
    Users getUser(Users users);

    /**
     * 获得用户集合对象
     * @return
     */
    List<Users> getUsersList();

    /**
     * 插入用户对象
     * @param users
     */
    void insertUser(Users users);


}
