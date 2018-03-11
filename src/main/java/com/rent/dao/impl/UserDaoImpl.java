package com.rent.dao.impl;

import com.rent.dao.UserDao;
import com.rent.entity.Users;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * 用户dao类
 */
public class UserDaoImpl implements UserDao {
    /**
     * 查找用户对象
     * @param users
     * @return
     */
    public Users getUser(Users users){
        Session session= HibernateUtil.openSession();
        String hql="from Users where username=:username and password=:password";
        Users  u = (Users) session.createQuery(hql).setProperties(users).uniqueResult();
        return u;
    }

    /**
     * 获得用户列表
     * @return
     */
    public List<Users> getUsersList(){
        Session session=HibernateUtil.openSession();
       return session.createQuery("from Users").list();
    }

    public void insertUser(Users users) {
        Session session=HibernateUtil.openSession();
        session.save(users);
    }

}
