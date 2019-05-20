package com.exam.todo.springtodo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ParseDate {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static Date createLastDate(){
        Date lastDate = new Date();
        try{
            lastDate = simpleDateFormat.parse("2999-01-01");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return lastDate;
    }

    public static Date stringToDate(String str){
        Date date = new Date();
        System.out.println("now date : " + date);
        try{
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            date = simpleDateFormat.parse(str);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return date;
    }
}
