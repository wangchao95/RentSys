package com.rent.biz.impl;

import com.rent.biz.TypeBiz;
import com.rent.dao.TypeDao;
import com.rent.dao.impl.TypeDaoImpl;
import com.rent.entity.Type;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TypeBizImpl implements TypeBiz {

    private TypeDao typeDao=new TypeDaoImpl();
    /**
     * 获得类型列表
     * @return
     */
    public List<Type> getTypeList() {
        Session session= HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        List<Type> typeList = typeDao.getTypeList();
        transaction.commit();
        return typeList;
    }
}
