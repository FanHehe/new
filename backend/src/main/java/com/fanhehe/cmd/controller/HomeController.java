package com.fanhehe.cmd.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
import com.fanhehe.cmd.dao.UserDao;
import com.fanhehe.cmd.entity.User;


@Controller
public class HomeController {

    @Autowired
    UserDao userDao;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {

//        logger.info("Welcome home! The client locale.");

        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "json", method = RequestMethod.GET)
    public Map<String, Object> json () {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("new", new User());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public User mysql () {
        logger.info("Welcome home! The client locale.");
        return userDao.getUserById(1);
    }

}
