package com.rent.biz.impl;

import com.rent.biz.UserBiz;
import com.rent.dao.UserDao;
import com.rent.dao.impl.UserDaoImpl;
import com.rent.entity.Users;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserBizImpl implements UserBiz {
    private UserDao userDao=new UserDaoImpl();

    /**
     * 登录方法
     * @param users
     * @return
     */
    public Users loginUser(Users users) {
        Users u=null;
        Session session= HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        u= userDao.getUser(users);
        transaction.commit();
        return u;
    }

    /**
     * 获得用户对象集合
     * @return
     */
    public List<Users> findUserList() {
        Session session=HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        List<Users> users=null;
        users=userDao.getUsersList();
        transaction.commit();
        return users;
    }


    public int registerUser(Users users) {
        Session session=HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        int count=0;
        try {
            userDao.insertUser(users);
            count=1;
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
        return count;
    }


}
