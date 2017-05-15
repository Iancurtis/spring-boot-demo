package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
class UserController {
    
    public static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value="/{user}", method=RequestMethod.GET)
    String getUser(@PathVariable Long user) {
        logger.debug("user long: " + user);
        return "hello users";
    }

}