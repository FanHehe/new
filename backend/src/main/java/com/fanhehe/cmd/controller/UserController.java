package com.fanhehe.cmd.controller;


import java.util.HashMap;
import com.fanhehe.common.model.User;
import com.fanhehe.common.service.UserService;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Reference(version="1.0.0")
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "user/user", method = RequestMethod.GET)
    public User user (
        @RequestParam(name = "id") long id
    ) {
        return userService.getUserInfoBy(id);
    }
}
