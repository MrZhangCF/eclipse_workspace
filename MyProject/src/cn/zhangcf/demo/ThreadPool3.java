package cn.zhangcf.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool3 {
	public static void main(String[] args) {
		
		//这里限制线程的数量，即最多使用3个线程进行计算。
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
