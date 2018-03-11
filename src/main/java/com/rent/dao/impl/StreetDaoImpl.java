package com.rent.dao.impl;

import com.rent.dao.StreetDao;
import com.rent.entity.District;
import com.rent.entity.Street;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StreetDaoImpl implements StreetDao {


    public List<Street> getStreetList(District district) {
        Session session = HibernateUtil.openSession();
        String hql="from Street s ";
        if(district!=null&&district.getId()!=0){
            hql+=" where s.district.id=:id";
            return session.createQuery(hql).setProperties(district).list();
        }
        return session.createQuery(hql).list();
    }

}
