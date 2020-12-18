package com.zking.ssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class CXTest extends TimerTask {
    //测试的是一个“计时器”
    //① java.util.timer 工具来完成定时操作
    //②开源框架，调度器Quartz（本次不使用），更好的选择
    private static int count = 30;

    public static void setCount(int count) {
        CXTest.count = count;
    }

    private static Timer timer = new Timer();
//    private static Timer timer = new Timer();
    public void run(){
//        System.out.println("定时任务正在执行.....");
        count--;
        int minute = count/60;
        //秒
        int sec = count%60;
        //小时
        int hour = minute/60;
        //分钟
        int min = minute%60;
        System.out.println("显示还剩余上机时间："+hour+":"+min+":"+sec+"");

        if(5==count){
            System.err.println("还有5秒.....请及时充值");
        }
        //本次执行有效，推荐api写入run
        if(0==count){
            System.err.println("系统关闭......");
            CXTest.close();
        }
//        System.out.println("定时任务执行完毕.....");
    }

    //计时器
    public static void cf(){
        //三秒调用一次
        timer.schedule(new CXTest(),1000,1000);
        System.err.println("正式启动记时器......");
    }

    //计时器关闭api
    public static void close(){
        timer.cancel();
    }

    //时间转换器
    //小时-->秒
    public static int hourTFT(int hour,int minute,int second){
        //时间转换的公式
//        1小时=60分钟=3600秒=3600000毫秒，1分钟=60秒=60000毫秒，1秒=1000毫秒
        // 获取当前日历
        Calendar c = Calendar.getInstance();
//        System.out.println("--处理后--");
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int our = c.get(Calendar.HOUR_OF_DAY)+hour;
        int min = c.get(Calendar.MINUTE)+minute;
        int sec = c.get(Calendar.SECOND)+second;
        String time = year + "/" + month + "/" + date + " " +our + ":" +min + ":" + sec;
        System.out.println("失效时间为"+time);
        return sec;
    }

    @Test
    public void test(){
        // 日历
        Calendar c = Calendar.getInstance();
        // 日期
        Date d = c.getTime();
        // 简单的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        // 格式
        String time = sdf.format(d);
        System.out.println(time);
        System.out.println(d.getTime());
        System.out.println("----------------");
        System.out.println(System.currentTimeMillis());
        int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH);

        int date = c.get(Calendar.DATE);

        int hour = c.get(Calendar.HOUR_OF_DAY);

        int minute = c.get(Calendar.MINUTE);

        int second = c.get(Calendar.SECOND);

        System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second);
    }


    //测试客户端运行消息
    public static void main(String[] args) throws InterruptedException {
/**        如果没有设置默认30秒关闭此类
 *          This class is turned off by default for 30 seconds if not set
  */
//        int hour = 0;
//        int sec = CXTest.hourTFT();
//        CXTest.setCount(sec);
//      计时器启动开关
                CXTest.cf();
//        程序设置默认关闭时间（一分钟后关闭）,不推荐占内存
//        int time = 60000;
//        Thread.sleep(time);
//        程序默认关闭时间，推荐使用（问题此次调用方法不成功！）不推荐
//        if(30==count){
//            System.err.println("系统关闭......");
//            CXTest.close();
//        }

        //设置小时
//        int hour = 2;
//        CXTest.hourTFT(hour);
//
//        System.out.println("关闭此类....");
//        timer.cancel();


    }

}