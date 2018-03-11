package com.rent.unil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 工具类
 */
public class HibernateUtil {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    /**
     * 类加载的时候就会执行的代码
     */
    static{
        configuration=new Configuration().configure("hibernate.cfg.xml");
        sessionFactory=configuration.buildSessionFactory();
    }

    /**
     * 获得会话
     * @return
     */
    public  static Session openSession(){
        return sessionFactory.getCurrentSession();
    }
}
