package com.rent.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 区县类
 */
public class District {
    private  int  id;
    private  String name;
//    private Set<Street> streetList=new HashSet<Street>();

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

//    public Set<Street> getStreetList() {
//        return streetList;
//    }
//
//    public void setStreetList(Set<Street> streetList) {
//        this.streetList = streetList;
//    }
}
