package com.fanhehe.cmd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;
import com.fanhehe.cmd.dao.UserDao;
import com.fanhehe.cmd.entity.User;
import com.fanhehe.cmd.service.HomeService;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("Base")
    private HomeService homeService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(long uid, Model model) {

        long userId = uid > 0 ? uid : 1;

        User user = userDao.getUserById(userId);

        logger.info("aaaaaaaaaaaaa{}.", String.valueOf(uid));

        Map<String, String> result = homeService.handleIndex(Optional.ofNullable(user));

        for (String key: result.keySet()) {
            model.addAttribute(key, result.get(key));
        }

        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "json", method = RequestMethod.GET)
    public Map<String, Object> json () {

        Map<String, Object> result = homeService.handleJson();

        for(Map.Entry<String, Object> entry: result.entrySet()) {
            logger.info("iterator: {} => {}", entry.getKey(), entry.getValue());
        }

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public User user (
        @RequestParam(name = "user_id") int userId,
        @RequestParam(name = "password") String password
    ) {
        logger.info("Welcome home! The client locale." + password);
        return userDao.getUserById(userId);
    }
}
