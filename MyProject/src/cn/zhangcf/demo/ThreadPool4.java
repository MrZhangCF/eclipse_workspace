package cn.zhangcf.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool4 {
	public static void main(String[] args) {
		
		//定义了一个具备三个线程大小的定时调度线程池
		ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
		for(int x = 0; x < 10 ; x ++){
			int index = x;
			es.scheduleAtFixedRate(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() + " = " + index);
				}
				
			}, 3, 2, TimeUnit.SECONDS);  //arg0:Runnable对象，表示线程对象操作。
								   //arg1:表示延时
								   //arg2:表示时间间隔
								   //arg3：表示时间的单位
								   //所以上式表示的含义即是:3秒后开始执行，而后，每2秒执行一次。
		}
	}
}
