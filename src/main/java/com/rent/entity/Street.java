package com.rent.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 街道类
 */
public class Street {

    private int  id;
    private String name;
    private District district;   //区县

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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
