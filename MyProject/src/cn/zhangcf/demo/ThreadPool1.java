package cn.zhangcf.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool1 {
	public static void main(String[] args) {
		//������һ�����޴�С���̳߳ص�ģ�ͣ���������������ʱ��������̡߳�
		ExecutorService es = Executors.newCachedThreadPool();
		for(int x = 0; x<10; x++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int index = x;
			es.submit(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() + ", x = " + index);
				}
				
			});
		}
		es.shutdown();
	}
}
