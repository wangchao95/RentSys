package com.rent.biz.impl;

import com.rent.dao.DistrictDao;
import com.rent.dao.impl.DistrictDaoImpl;
import com.rent.entity.District;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DistrictBizImpl implements com.rent.biz.DistrictBiz {

    private DistrictDao districtDao=new DistrictDaoImpl();

    public List<District> getDistrictList() {
        Session session= HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        List<District> districtList=districtDao.getDistrictList();
        transaction.commit();
        return districtList;
    }
}
