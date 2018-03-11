package com.rent.unil;

import com.rent.entity.House;
import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

public class TypeConvter extends StrutsTypeConverter {



    public Object convertFromString(Map map, String[] strings, Class aClass) {
        House house=new House();
        for(int i=0;i<strings.length;i++){
            String[] str=strings[i].split("-");
            if(i==0){
                house.setMinPrice(Integer.parseInt(str[0]));
                house.setMaxPrice(Integer.parseInt(str[1]));
            }else{
                house.setMinFloorage(Integer.parseInt(str[0]));
                house.setMaxFloorage(Integer.parseInt(str[1]));
            }
        }
        return house;
    }

    public String convertToString(Map map, Object o) {
        return null;
    }
}
