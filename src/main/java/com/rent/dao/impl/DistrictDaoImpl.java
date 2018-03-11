package com.rent.dao.impl;

import com.rent.dao.DistrictDao;
import com.rent.entity.District;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DistrictDaoImpl implements DistrictDao {



    public List<District> getDistrictList() {
        return   HibernateUtil.openSession().createQuery("from District").list();
    }
}
