package com.tjx.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Editor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat sdf = getSimpleDateFormat(text);
        Date date = null;
        try {
            date = sdf.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private SimpleDateFormat getSimpleDateFormat(String s) throws TypeNotPresentException{
        SimpleDateFormat sdf = null;
        if (Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$",s)){
            sdf = new SimpleDateFormat("yyyy/MM/dd");
        }else if (Pattern.matches("\\d{4}\\+\\d{2}\\+\\d{2}$",s)){
            sdf = new SimpleDateFormat("yyyy+MM+dd");
        }else if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",s)){
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }else{
            throw new TypeMismatchException("",Date.class);
        }
        return sdf;
    }
}
