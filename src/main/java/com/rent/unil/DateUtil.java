package com.rent.unil;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtil {
    public static Date getDate(){
        Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
        ca.setTime(new Date()); // 设置时间为当前时间
       // ca.set(2011, 11, 17);// 月份是从0开始的，所以11表示12月
       // ca.add(Calendar.YEAR, -1); // 年份减1
        ca.add(Calendar.MONTH, -1);// 月份减1
      //  ca.add(Calendar.DATE, -1);// 日期减1
        Date resultDate = ca.getTime(); // 结果
        return resultDate;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(resultDate));
    }
}
