package com.example.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

// TODO: 这里@Repository的使用还是有疑问。但如果不加，在UserServiceImpl中的DI就会报错。
@Repository
public class User {
    private String name;
    private String password;
    private int age;
    @DateTimeFormat(iso=ISO.DATE)
    private Date date;
    @DateTimeFormat(iso=ISO.TIME)
    private Date time;

    public User() {

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Date time) {
        this.time = time;
    } 

    public Date getTime() {
        return time;
    }
}