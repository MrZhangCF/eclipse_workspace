package cn.zhangcf.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool3 {
	public static void main(String[] args) {
		
		//���������̵߳������������ʹ��3���߳̽��м��㡣
		//ExecutorService es = Executors.newScheduledThreadPool(3);
		ExecutorService es = Executors.newFixedThreadPool(3);
		for(int x = 0;x < 10;x ++){
			int index = x;
			es.submit(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() + " = " + index);
				}
				
			});
		}
		es.shutdown();
	}
}
