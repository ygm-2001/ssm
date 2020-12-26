package com.zking.ssm.job;

import com.zking.ssm.util.MyUtil;
import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class MyJob implements Job{
    private static int count;
    private static Scheduler scheduler= null;

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(MyUtil.getDefaultTime());
        System.out.println("---计数---："+count++);
        if(60==count){
            scheduler.shutdown();
            System.out.println("关闭了");
        }
    }

    public static void countComputer() throws SchedulerException {
        //1.创建一个任务
        JobDetail jobDetail=new JobDetailImpl("myJob1","group1",MyJob.class);
        //2.解释：创建一个触发器(简单复杂触发器SimpleTriggerImpl)，每间隔2秒执行1次  一共执行10次！
        Trigger trigger =new SimpleTriggerImpl("trigger1",10,1000);

        //3.创建一个调度器
        scheduler=new StdSchedulerFactory().getScheduler();
        //4.调度任务
        scheduler.scheduleJob(jobDetail,trigger);
        //5.启动
        scheduler.start();
    }

    public static void quar_count() throws SchedulerException {
        //1.从工厂中获取调度器实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //2.创建JobDetail
        JobDetail job = JobBuilder
                .newJob(MyJob.class)
                .withIdentity("myjob", "group1")//job的name和group
                .build();
        //3.创建Trigger
        Trigger trigger=TriggerBuilder.newTrigger()
                .withIdentity("trigger", "Tgr_group")//trigger的name和group
                .startNow()//设置开启触发器
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))//每隔1秒执行1次
                .build();

        //把作业和触发器注册到任务调度中
        scheduler.scheduleJob(job, trigger);
        //☆启动调度
        scheduler.start();
    }

    public static void quar_count2() throws SchedulerException {
        //1.从工厂中获取调度器实例
        scheduler = StdSchedulerFactory.getDefaultScheduler();
        //2.创建JobDetail
        JobDetail job = JobBuilder
                .newJob(MyJob.class)
                .withIdentity("jobYgm", "jobYgm")//job的name和group
                .build();
        //3.创建Trigger
        Trigger trigger=TriggerBuilder.newTrigger()
                .withIdentity("tgrYgm", "tgrYgmGroup")//trigger的name和group
                .startNow()//设置开启触发器
                .withSchedule(// 定义调度触发规则
                        SimpleScheduleBuilder
                                .repeatSecondlyForTotalCount(1, 1)//重复5次,每次间隔5秒
                )
                .build();
        //把作业和触发器注册到任务调度中
        scheduler.scheduleJob(job, trigger);
        //☆启动调度
        scheduler.start();
    }

}
