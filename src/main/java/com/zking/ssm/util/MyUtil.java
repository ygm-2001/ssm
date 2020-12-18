package com.zking.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * 工具类
 *
 * 专门获取随机数据
 *
 * 对属性赋值（测试）
 *
 * @author Administrator ygm
 */
public class MyUtil {




    /**
     * 获取当前时间：
     *
     * 判断是否为上午(第一天早上6-11末) 中午(11-12末) 还是下午(13-18末) 或是晚上(19-第二天早上5点末)
     *
     * @return 2020年12月11日 上午 08时:44分:29秒
     */
    public static String getComplexTime() {
        String period = null;
        // 日历
        Calendar c = Calendar.getInstance();
        // 日期
        Date d = c.getTime();
        int weTime = d.getHours();
        if(weTime==6 || weTime==7 || weTime==8 || weTime ==9 || weTime==10 || weTime==11) {
            period = "上午";
        }else if(weTime==12) {
            period = "中午";
        }else if(weTime==13 || weTime==14 || weTime==15 || weTime==16 || weTime==17 || weTime==18) {
            period = "下午";
        }else{
            period = "晚上";
        }
        // 简单的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH时:mm分:ss秒");
        // 格式
        String time = sdf.format(d);
        //破碎重组
        String sub = time.substring(0, 11);//2020年06月05日
        String sub2 = time.substring(12, 24);//14时:49分:17秒
        return sub+" "+period+sub2;
    }

    /**
     * 获取当前时间：
     * @return 2020年12月11日 08时:44分:29秒
     */
    public static String getDefaultTime(){
        // 日历
        Calendar c = Calendar.getInstance();
        // 日期
        Date d = c.getTime();
        // 简单的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒");
        // 格式
        String time = sdf.format(d);
        return time;
    }

    /**
     * 获取当前时间：
     * @return 2020/12/11 08:44:29
     */
    public static String getSimpleTime(){
        // 日历
        Calendar c = Calendar.getInstance();
        // 日期
        Date d = c.getTime();
        // 简单的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // 格式
        String time = sdf.format(d);
        return time;
    }

    /**
     * 获取随机姓名：
     * 常用的姓名
     * @return 中文人名
     */
    public static String getName(){
        //随机姓
        String sjx[] = {"袁","陈","王","曾"};
        //随机名，分为单名区，双名区，多名区
        String sjm[] = {"公","子","明","宇","翔","公明","宇翔",""};

        return null;
    }

//    随机字段：
//    0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$%^&*()-_=+\|[]{};:'",.<>/?

    /*
    * 获取当前时间代码Date
    * */
//    Date date = new Date();
//
//    String year = String.format("%tY", date);
//
//    String month = String.format("%tB", date);
//
//    String day = String.format("%te", date);
//
//        System.out.println("今天是："+year+"-"+month+"-"+day);

    /**
     * 测试*代码
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("测试：获取当前时间......");
        System.out.println("第①种："+MyUtil.getComplexTime());
        System.out.println("第②种："+MyUtil.getDefaultTime());
        System.out.println("第③种："+MyUtil.getSimpleTime());


    }
}
