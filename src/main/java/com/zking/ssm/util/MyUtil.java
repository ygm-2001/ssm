package com.zking.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

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

    /**
     * 通过身份证件判断是否成年
     * 前提一定要正确的身份证号信息
     * @param identity
     * @return
     */
    public static boolean isAdult(String identity){
        boolean flag = true;
        String pattern = "^[1-9]\\d{5}[1-9]\\d{3}((0[1-9])|(1[0-2]))(0[1-9]|([1|2][0-9])|3[0-1])((\\d{4})|\\d{3}X)$";
        boolean isMatch = Pattern.matches(pattern, identity);
        //有效身份证
        if(isMatch){
            //截取身份证上的有效信息430527 20011017 6976
            //截取出生年月日
            //String转int
//            my年
            int myYear =Integer.parseInt(identity.toString().substring(6,10));
//            my月
            int myMonth =Integer.parseInt(identity.toString().substring(10,12));
//            my日
            int myDate =Integer.parseInt(identity.toString().substring(12,14));
            //获取到当前年月日
            Calendar c = Calendar.getInstance();
//            年
            int year = c.get(Calendar.YEAR);
//            月(加1，是内部api是从0~11计算的所以不必感到疑惑)
            int month = c.get(Calendar.MONTH)+1;
//            日
            int date = c.get(Calendar.DATE);
            //            2019 11 18    2020 12 20
            //            2001 12 17    2002 12 22
            //            0018 01 01    0018 00 -02
//          首先my年-年
            if((year-myYear)>18){
                flag = true;
            }else if((year-myYear)==18){
                if((month-myMonth)>0){
                    flag = true;
                }else if((month-myMonth)==0){
                    if((date-myDate)>0 || (date-myDate)==0){
                        flag = true;
                    }else{
                        flag = false;
                    }
                }else{
                    flag = false;
                }
            }else{
                flag = false;
            }
        }else{
            flag = false;
        }
        return flag;
    }

    /**
     * 测试*代码
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("测试：获取当前时间......");
        System.out.println("第①种："+MyUtil.getComplexTime());
        System.out.println("第②种："+MyUtil.getDefaultTime());
        System.out.println("第③种："+MyUtil.getSimpleTime());
//        String类型获取时间
        Date date = new Date();
        /**
         * %tB 或 %tb 十二月
         *
         */
        String year = String.format("%tY", date);
        String month = String.format("%tm", date);
        String day = String.format("%te", date);
        System.out.println("今天是："+year+"-"+month+"-"+day);
//
        System.out.println("是否成年输出结果："+MyUtil.isAdult("430527200110176976"));
        System.out.println("是否成年输出结果："+MyUtil.isAdult("430527200309091814"));
        System.out.println("是否成年输出结果："+MyUtil.isAdult("430527200212206976"));
        System.out.println("是否成年输出结果："+MyUtil.isAdult("430527200212206976"));


    }
}
