package lidahai.testcalendaTrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class CladendaTirgerTest {
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory shed = new StdSchedulerFactory();
		Scheduler scheduler = shed.getScheduler();
		//��Ҫ��5��֮����������ÿ��2��ִ���������ִ��501
		long currentTime = System.currentTimeMillis();
		long delayTime = currentTime + 5*1000l;
		
		//ÿ��ִ��һ��
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("tr1", "group1").
				startAt(new Date(delayTime)).withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInMonths(1)).build();
//		CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInWeeks(1)
		
		JobDetail jobDetail = JobBuilder.newJob(MyJobDetail.class).withIdentity("job1", "group1").usingJobData("user", "lidahai").build();
		
		scheduler.scheduleJob(jobDetail, trigger);
		 
		scheduler.start();
		
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scheduler.shutdown();
	}

}
