package lidahai.testsimpletrigger3;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;

@DisallowConcurrentExecution
public class MyJobDetail1 implements Job{
    public String name;
    
    
	public void execute(JobExecutionContext context) throws JobExecutionException {
		if("xiaoming".equals(name)){
			System.out.println("time is =="+getTime()+"==hello myjobdetail -- ���Ǹ�С��������");
			System.out.println("���ʼ���С��");
		}
		if("xiaogao".equals(name)){
			System.out.println("time is =="+getTime()+"==hello myjobdetail -- ���Ǹ�С�ߵ�����");
			System.out.println("���ʼ���С��");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getTime(){
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
		Long millis = System.currentTimeMillis();
		String returnString = dateformat.format( millis);
		return returnString;
	}
}
