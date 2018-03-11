package com.rent.entity;

import org.hibernate.dialect.Oracle10gDialect;

import java.util.HashSet;
import java.util.Set;

/**
 * 房屋类型
 */
public class Type {
    private int id;
    private String name;

//    private Set<House> houseSet=new HashSet<House>();
//
//    public Set<House> getHouseSet() {
//        return houseSet;
//    }
//
//    public void setHouseSet(Set<House> houseSet) {
//        this.houseSet = houseSet;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
