package com.rent.biz;

import com.rent.entity.Users;

import java.util.List;

public interface UserBiz {
    /**
     * 登录
     * @param users
     * @return
     */
    Users loginUser(Users users);

    /**
     * 获得所有用户对象
     * @return
     */
    List<Users> findUserList();

    /**
     * 注册用户对象
     * @param users
     * @return
     */
    int registerUser(Users users);


}
