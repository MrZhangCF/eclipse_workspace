package cn.zhangcf.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool2 {
	public static void main(String[] args) {
		
		//���ﶨ���˵��̳߳ز�����������Կ���������������һ���߳���ɣ�ʲôʱ�����ʲôʱ���㡣
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
