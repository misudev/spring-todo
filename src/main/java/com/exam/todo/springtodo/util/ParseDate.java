package com.exam.todo.springtodo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ParseDate {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date stringToDate(String str){
        Date date = new Date();
        try{
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            date = simpleDateFormat.parse(str);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return date;
    }
}
