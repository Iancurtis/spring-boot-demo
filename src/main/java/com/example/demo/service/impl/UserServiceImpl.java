package com.example.demo.service.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    public static final Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private User user;

    public String getUser(long id) {
        return "not implemented.";
    }

    public void timeFormatShow() {
        Date d = new Date();
        user.setDate(d);
        user.setTime(d);
        logger.debug("date: " + user.getDate());
        logger.debug("time: " + user.getTime());
    }
}