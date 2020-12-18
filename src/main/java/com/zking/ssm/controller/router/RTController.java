package com.zking.ssm.controller.router;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RTController {

    @RequestMapping("/rtc1")
    public String hello(){
        return "forward:/hello3";
    }

    @RequestMapping("/rtc2")
    public String hello(String str){
        return "redirect:/hello3?name=ygm&n1=9&n2=78520";
    }

    @RequestMapping("/common/index.html")
    public String toIndexJSP(){
        return "index";
    }

}
