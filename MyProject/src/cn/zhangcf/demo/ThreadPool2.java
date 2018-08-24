package cn.zhangcf.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool2 {
	public static void main(String[] args) {
		
		//这里定义了单线程池操作，结果可以看到，整个过程由一个线程完成，什么时候结束什么时候算。
		ExecutorService es = Executors.newSingleThreadExecutor();
		for(int x = 0; x< 10;x++){
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
