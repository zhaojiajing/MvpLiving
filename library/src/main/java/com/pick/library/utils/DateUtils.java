package com.pick.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 类描述：
 * 创建人：zhaojingjing
 * 创建时间：2016/7/12 14:26
 */
public class DateUtils {

    public static String formatDate(String date){
        SimpleDateFormat dateFm1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFm2 = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return dateFm2.format(dateFm1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatTime(String date){
        SimpleDateFormat dateFm1 = new SimpleDateFormat("HHmm");
        SimpleDateFormat dateFm2 = new SimpleDateFormat("HH:mm");
        try {
            return dateFm2.format(dateFm1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
