package com.fanhehe.cmd.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;

import com.mysql.jdbc.*;

@Controller
public class HomeController {

    public HomeController () {}

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {

        logger.info("Welcome home! The client locale.");

        System.out.print(1);

        return "home";
    }

    @RequestMapping(value = "/req", method = RequestMethod.GET)
    public String req (HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }

}
