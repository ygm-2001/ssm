package com.zking.ssm.job;

import com.zking.ssm.util.JsonData;
import com.zking.ssm.util.MyUtil;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class MyJobTest {
    public static void main(String[] args) throws Exception{
//        MyJob.countComputer();
//          MyJob.quar_count();
//        MyJob.quar_count2();
        ComputerJobController cjc = new ComputerJobController();
        String open = ComputerJobController.startCount();
        System.out.println(open);
        String open2 = ComputerJobController.startCount2();
        System.out.println("第二个打开"+open2);

        Thread.sleep(20000);
        String over = ComputerJobController.overCount();
        System.out.println(over);
    }

}
