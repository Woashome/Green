package com.example.green.local_utils;

/**
 * @ProjectName: Green
 * @Package: com.example.green.local_utils
 * @ClassName: DateUtil
 * @Author: hjl
 * @email: 51721997@163.com
 * @Description: java类作用描述
 * @CreateDate: 2019/12/31 18:56
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by niwoxuexi.com on 2017/6/23.
 */

public class DateUtil {


    /**
     * 获取系统时间戳
     *
     * @return
     */
    public static long getCurTimeLong() {
        long time = System.currentTimeMillis();
        return time;
    }

    /**
     * 获取当前时间
     *
     * @param pattern
     * @return
     */
    public static String getCurDate(String pattern) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern);
        return sDateFormat.format(new java.util.Date());
    }

    /**
     * 时间戳转换成字符串
     *
     * @param milSecond
     * @param pattern
     * @return
     */
    public static String getDateToString(long milSecond, String pattern) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 将字符串转为时间戳
     *
     * @param dateString
     * @param pattern
     * @return
     */
    public static long getStringToDate(String dateString, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
}