package com.rent.biz.impl;

import com.rent.biz.StreetBiz;
import com.rent.dao.StreetDao;
import com.rent.dao.impl.StreetDaoImpl;
import com.rent.entity.District;
import com.rent.entity.Street;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StreetBizImpl implements StreetBiz {

    private StreetDao streetDao=new StreetDaoImpl();

    /**
     * 获得区县下的街道
     * @param district
     * @return
     */
    public List<Street> getStreets(District district) {
        Session session= HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        List<Street> streetList = streetDao.getStreetList(district);
        transaction.commit();
        return streetList;
    }
}
