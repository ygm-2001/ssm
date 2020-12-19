package com.zking.ssm.controller;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public void Login(){
        System.out.println("登录---login");
        User user = userService.selectByPrimaryKey(1L);
        System.out.println(user);
    }

    @RequestMapping("/login2")
    public String Login2(){
        System.out.println("登录...login2");
        return "index";
    }
}
