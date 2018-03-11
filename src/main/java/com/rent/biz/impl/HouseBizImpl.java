package com.rent.biz.impl;

import com.rent.biz.HouseBiz;
import com.rent.dao.HouseDao;
import com.rent.dao.impl.HouseDaoImpl;
import com.rent.entity.House;
import com.rent.entity.Page;
import com.rent.entity.Users;
import com.rent.unil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HouseBizImpl implements HouseBiz{

    private HouseDao houseDao=new HouseDaoImpl();
    /**
     * 添加房屋
     * @param house
     * @return
     */
    public int addHouse(House house) {
        Session session= HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            houseDao.addHouse(house);
            transaction.commit();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return -1;
        }
    }

    /**
     * 获得用户下的房屋集合和房屋
     * @param users
     * @return
     */
    public List<House> getHouseByUser(Users users) {
        Session session=HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        List<House> houseByUser = houseDao.getHouseByUser(users);
        transaction.commit();
        return houseByUser;
    }

    /**
     * 删除房屋信息
     * @param house
     * @return
     */
    public int removeHouse(House house) {
        Session session=HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            houseDao.deleteHouse(house);
            transaction.commit();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return -1;
        }
    }

    /**
     * 分页获得详情
     * @param house
     * @param page
     */
    public void getPageInfo(House house, Page page) {
        Session session=HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        //设置总行数
        page.setTotalCount(houseDao.getTotalCount(house));
        List<House> pageListByParam = houseDao.getPageListByParam(house, page);
        //获得每页显示的信息集合
        page.setPageList(pageListByParam);
        transaction.commit();
    }

    /**
     * 通过id获得house
     * @param id
     * @return
     */
    public House getHouseById(int id) {
        House house=new House();
        house.setId(id);
        Session session=HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        house= houseDao.getHouseByParam(house);
        transaction.commit();
        return house;
    }

}
