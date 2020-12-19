package com.zking.ssm.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CXTController {
    /**
     * 每天22点30启动任务
     */
    @Scheduled(cron = "0 30 22 ? * *")
    @RequestMapping("/test1")
    public String test(){
        return "forward:/hello3";
    }

    @RequestMapping("/time")
    public String t(){
        return "forward:/test2";
    }

    int count = 0;
//    @Scheduled(cron = "0/1 * * * * ?")//每隔5秒隔行一次--->每隔一秒
    @RequestMapping("/test2")
    @ResponseBody
    public String test1(){
        count++;
        int minute = count/60;
        //秒
        int sec = count%60;
        //小时
        int hour = minute/60;
        //分钟
        int min = minute%60;
        System.out.println("显示还上机时间："+hour+":"+min+":"+sec);
        return hour+":"+min+":"+sec;
    }

    int count2 = 0;
//    @Scheduled(cron = "0/1 * * * * ?")//每隔5秒隔行一次--->每隔一秒
    @RequestMapping("/test")
    @ResponseBody
    public String test12(){
        count2++;
        int minute = count2/60;
        //秒
        int sec = count2%60;
        //小时
        int hour = minute/60;
        //分钟
        int min = minute%60;
        System.out.println("显示时间1："+hour+":"+min+":"+sec);
        return hour+":"+min+":"+sec;
    }
    @RequestMapping("/test3")
    public String test2(){
        return "index";
    }

}
