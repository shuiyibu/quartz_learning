package lidahai.testdailytrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestDailyTimeTrigger {
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory sched = new StdSchedulerFactory();
		Scheduler scheduler = sched.getScheduler();
		
		//�����������ÿ��9�㿪ʼִ�У��������5�����ִ�У�ÿ��1Сʱִ��һ��
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("tr1", "group1").
				withSchedule(DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule().startingDailyAt(TimeOfDay.hourAndMinuteOfDay(9, 0))//������ָ9�㿪ʼ
						.endingDailyAt(TimeOfDay.hourAndMinuteOfDay(17, 0)).withIntervalInHours(1).withRepeatCount(14)).build();
		
//		//�����������ÿ��9�㿪ʼִ�У�������5��ִ����ϣ�ÿ��Сʱִ��һ�Σ���һ������ִ��
//		DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule().startingDailyAt(TimeOfDay.hourAndMinuteOfDay(9, 0))//������ָ9�㿪ʼ
//		.endingDailyAt(TimeOfDay.hourAndMinuteOfDay(17, 0)).withIntervalInHours(1).withRepeatCount(14).onDaysOfTheWeek(java.util.Calendar.MONDAY,java.util.Calendar.TUESDAY,java.util.Calendar.WEDNESDAY,java.util.Calendar.TUESDAY);
		
		JobDetail jobdetail = JobBuilder.newJob(MyJobDetail.class).withIdentity("job1", "group1").usingJobData("user","boob").build();
		scheduler.scheduleJob(jobdetail, trigger);
		
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scheduler.shutdown();
		
	}

}
