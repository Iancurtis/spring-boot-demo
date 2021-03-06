package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
class Home {

    public static final Log logger = LogFactory.getLog(Home.class);

    @Autowired
    UserService userService;

    @RequestMapping("/")
    String home() {
        userService.transfer();
        return "Hello world!!";
    }
}