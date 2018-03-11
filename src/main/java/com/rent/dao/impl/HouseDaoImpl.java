package com.rent.dao.impl;

import com.rent.dao.HouseDao;
import com.rent.entity.House;
import com.rent.entity.Page;
import com.rent.entity.Users;
import com.rent.unil.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class HouseDaoImpl implements HouseDao {

    /**
     * 添加房屋
     *
     * @param house
     */
    public void addHouse(House house) {
        HibernateUtil.openSession().save(house);
    }

    public List<House> getHouseByUser(Users users) {
        Session session = HibernateUtil.openSession();
        String hql = "from House h inner join fetch h.street.district d ";
        if (users != null) {
            hql += " where h.user.id=:id";
            return session.createQuery(hql).setProperties(users).list();
        }
        return session.createQuery(hql).list();
    }

    /**
     * 删除房屋信息
     *
     * @param house
     */
    public void deleteHouse(House house) {
        HibernateUtil.openSession().delete(house);
    }

    public List<House> getPageListByParam(House house, Page page) {
        String hql = "from House h inner join fetch h.street.district d where 1=1 ";
        Session session = HibernateUtil.openSession();
        Query query = null;
        if (house != null) {
            if (house.getTitle() != null && !"".equals(house.getTitle())) {
                hql += " and h.title like '%"+house.getTitle()+"%'";
            }
            if (house.getMaxPrice() > 0) {
                hql += " and h.price between :minPrice and :maxPrice";
            }
            if (house.getStreet().getId() > 0) {
                hql += " and h.street=:street";
            }
            if (house.getMaxFloorage() > 0) {
                hql += " and h.floorage between :minFloorage and :maxFloorage";
            }
            if (house.getType().getId() > 0) {
                hql += " and h.type=:type";
            }
        }
        if (house != null) {
            query = session.createQuery(hql).setProperties(house);
        } else {
            query = session.createQuery(hql);
        }
        query.setFirstResult((page.getCurrentPage() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query.list();
    }

    public int getTotalCount(House house) {
        String hql = " select count(h.id) from House h where 1=1 ";
        Session session = HibernateUtil.openSession();
        Query query = null;
        if (house != null) {
            if (house.getTitle() != null && !"".equals(house.getTitle())) {
                hql += " and h.title like '%"+house.getTitle()+"%'";
            }
            if (house.getMaxPrice() > 0) {
                hql += " and h.price between :minPrice and :maxPrice";
            }
            if (house.getStreet().getId() > 0) {
                hql += " and h.street=:street";
            }
            if (house.getMaxFloorage() > 0) {
                hql += " and h.floorage between :minFloorage and :maxFloorage";
            }
            if (house.getType().getId() > 0) {
                hql += " and h.type=:type";
            }
        }
        if (house != null) {
            query = session.createQuery(hql).setProperties(house);
        } else {
            query = session.createQuery(hql);
        }
        return Integer.valueOf(query.uniqueResult().toString());
    }


    public House getHouseByParam(House house) {
       return  (House) HibernateUtil.openSession().get(House.class, house.getId());
    }
}
