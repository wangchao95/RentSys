package com.rent.dao.impl;

import com.rent.dao.TypeDao;
import com.rent.entity.Type;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TypeDaoImpl implements TypeDao {

    public List<Type> getTypeList() {
        return HibernateUtil.openSession().createQuery("from Type").list();
    }
}
