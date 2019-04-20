package lidahai;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuzatTest {
	public static void main(String[] args) throws SchedulerException {
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		Trigger trigger = newTrigger().withIdentity("tr1", "group1")//���ô����������ֺ����
				.startNow()//����trigger
				.withSchedule(simpleSchedule().withIntervalInSeconds(1)//1�봥��һ������
						.repeatForever()//�����ȥ����
						).build();
		JobDetail jobdetail = newJob(MyJobDetail.class).withIdentity("jobdetail1", "group1").
				usingJobData("user", "bob")//���ʵ����������
				.build();
		scheduler.scheduleJob(jobdetail, trigger);
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
