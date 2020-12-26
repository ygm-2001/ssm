package com.zking.ssm.job;

import com.zking.ssm.util.JsonData;
import com.zking.ssm.util.MyUtil;
import lombok.Data;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/computer")
public class ComputerJobController implements Job {
    private static int countTime = 0;
//    定义一个定时器
    private static Scheduler scheduler= null;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//      简单的记录时间
            System.out.println(MyUtil.getDefaultTime());
            System.out.println(":--->"+countTime++);
            if(10==countTime){
                System.out.println("计时=="+countTime+"了");
            }
    }

//    开启定时器
    @RequestMapping("/startCount")
      public static String startCount(){
        String mgs = "无操作";
          //1.从工厂中获取调度器实例
          try {
              scheduler = StdSchedulerFactory.getDefaultScheduler();
              //2.创建JobDetail
              JobDetail job = JobBuilder
                      .newJob(ComputerJobController.class)
                      //job的name和group
                      .withIdentity("myjob", "group")
                      .build();
              //3.创建Trigger
              Trigger trigger=TriggerBuilder.newTrigger()
                      //trigger的name和group
                      .withIdentity("trigger", "Tgr_group")
                      //设置开启触发器
                      .startNow()
                      //每隔1秒执行1次
                      .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                      .build();

              //把作业和触发器注册到任务调度中
              scheduler.scheduleJob(job, trigger);
              //☆启动调度
              scheduler.start();
              mgs="计时开始";
          } catch (Exception e) {
              mgs="调度器开启异常";
              System.err.println("调用重复，正在运行.............");
          }
        return mgs;
      }
    //    开启定时器
    @RequestMapping("/startCount2")
    public static String startCount2(){
        String mgs = "无操作";
        //1.从工厂中获取调度器实例
        try {
            //1.从工厂中获取调度器实例
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            //2.创建JobDetail
            JobDetail job = JobBuilder
                    .newJob(ComputerJobController.class)
                    .withIdentity("jobYgm", "jobYgm")//job的name和group
                    .build();
            //3.创建Trigger
            Trigger trigger=TriggerBuilder.newTrigger()
                    .withIdentity("tgrYgm", "tgrYgmGroup")//trigger的name和group
                    .startNow()//设置开启触发器
                    .withSchedule(// 定义调度触发规则
                            SimpleScheduleBuilder
                                    .repeatSecondlyForTotalCount(10, 1)//重复5次,每次间隔5秒
                    )
                    .build();
            //把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            //☆启动调度
            scheduler.start();
            mgs="计时开始";
        } catch (Exception e) {
            e.printStackTrace();
            mgs="调度器开启异常";
            System.err.println("调用重复，正在运行.............");
        }
        return mgs;
    }
    //    开启定时器
    @RequestMapping("/startCount3")
    public static String startCount3(){
        String mgs = "无操作";
        //1.从工厂中获取调度器实例
        try {
            //1.从工厂中获取调度器实例
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            //2.创建JobDetail
            JobDetail job = JobBuilder
                    .newJob(ComputerJobController.class)
                    .withIdentity("jobYgm212", "jobYgm212")//job的name和group
                    .build();
            //3.创建Trigger
            Trigger trigger=TriggerBuilder.newTrigger()
                    .withIdentity("tgrYgm212", "tgrYgmGroup212")//trigger的name和group
                    .startNow()//设置开启触发器
                    .withSchedule(// 定义调度触发规则
                            SimpleScheduleBuilder
                                    .repeatSecondlyForTotalCount(2, 10)//重复1次,每次间隔5秒
                    )
                    .build();
            //把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            //☆启动调度
            scheduler.start();
            mgs="计时开始";
        } catch (Exception e) {
            e.printStackTrace();
            mgs="调度器开启异常";
            System.err.println("调用重复，正在运行.............");
        }
        return mgs;
    }

    //    开启定时器
    @RequestMapping("/startCount4")
    public static String startCount4(){
        String mgs = "无操作";
        //1.从工厂中获取调度器实例
        try {
            //1.从工厂中获取调度器实例
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            //2.创建JobDetail
            JobDetail job = JobBuilder
                    .newJob(ComputerJobController.class)
                    .withIdentity("jobYgm212", "jobYgm212")//job的name和group
                    .build();
            //3.创建Trigger
            Trigger trigger=TriggerBuilder.newTrigger()
                    .withIdentity("tgrYgm212", "tgrYgmGroup212")//trigger的name和group
                    .startNow()//设置开启触发器
                    .withSchedule(
                                SimpleScheduleBuilder.simpleSchedule()
                                            .withIntervalInSeconds(2)
                                            .withRepeatCount(0)
                    )
                    .build();
            //把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            //☆启动调度
            scheduler.start();
            mgs="计时开始";
        } catch (Exception e) {
            mgs="调度器开启异常";
            System.err.println("调用重复，正在运行.............");
        }
        return "index";
    }

//      关闭计时器
    @RequestMapping("/overCount")
    public static String overCount(){
        String mgs = "无操作";
        try{
            scheduler.shutdown();
            mgs="计时关闭";
        }catch (Exception e){
            e.printStackTrace();
            mgs="调度器关闭异常";
        }
        return mgs;
    }

}
