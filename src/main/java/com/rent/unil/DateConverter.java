package com.rent.unil;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import jdk.nashorn.internal.runtime.ECMAException;
import org.apache.struts2.util.StrutsTypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 时间类型转换器
 */
public class DateConverter extends StrutsTypeConverter {

    private  final DateFormat[] dfs={new SimpleDateFormat("yyyy/MM/dd"),new SimpleDateFormat("yyyy年MM月dd日"),new SimpleDateFormat("yyyy-MM-dd")};


    public Object convertFromString(Map map, String[] strings, Class aClass) {
        String date=strings[0];
        for (int i=0;i<dfs.length;i++){
            try {
                return (dfs[i]).parse(date);
            }catch (Exception e){
                continue;
            }
        }
        throw new TypeConversionException();
    }

    public String convertToString(Map map, Object o) {
        Date date=(Date)o;
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
