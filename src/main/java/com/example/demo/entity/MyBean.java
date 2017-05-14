package com.example.demo.entity;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class MyBean implements CommandLineRunner {

    public static final Log logger = LogFactory.getLog(MyBean.class);

    @Autowired
    public MyBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        Set<String> files = args.getOptionNames();
        System.out.println("debug: " + debug);
        System.out.println("files: " + files);
    }

    public void run(String... args) {
        logger.warn("=====================================");
    }
}