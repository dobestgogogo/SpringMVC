package com.tjx.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Convert implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = getSimpleDateFormat(s);
        Date date = null;
        try {
            date=sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private SimpleDateFormat getSimpleDateFormat(String s) throws TypeNotPresentException {
        SimpleDateFormat sdf = null;
        if (Pattern.matches("^\\d{4}/\\d{2}/\\d{2}",s)){
            sdf = new SimpleDateFormat("yyyy/MM/dd");
        }else if (Pattern.matches("^\\d{4}\\+\\d{2}\\+\\d{2}$",s)){
            sdf = new SimpleDateFormat("yyyy+MM+dd");
        }else if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",s)){
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }else{
            throw new TypeMismatchException("",Date.class);
        }
        return sdf;
    }
}
