package com.zking.ssm.controller;

import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String Login(Model model){
        System.out.println("登录---login");
        User user = userService.selectByPrimaryKey(1L);
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/add")
    public String Add(Model model,User user){
        String mgs = "未";
        if(null!=user.getName() && !"".equals(user.getName())){
            int i = userService.insertSelective(user);
            if(1==i){
                mgs = "注册成功";
                model.addAttribute("addUser",user);
            }else{
                mgs="注册失败";
            }
        }else{
            mgs = "用户名不能为空";
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }

}
