package cn.zhangcf.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool4 {
	public static void main(String[] args) {
		
		//������һ���߱������̴߳�С�Ķ�ʱ�����̳߳�
		ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
		for(int x = 0; x < 10 ; x ++){
			int index = x;
			es.scheduleAtFixedRate(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() + " = " + index);
				}
				
			}, 3, 2, TimeUnit.SECONDS);  //arg0:Runnable���󣬱�ʾ�̶߳��������
								   //arg1:��ʾ��ʱ
								   //arg2:��ʾʱ����
								   //arg3����ʾʱ��ĵ�λ
								   //������ʽ��ʾ�ĺ��弴��:3���ʼִ�У�����ÿ2��ִ��һ�Ρ�
		}
	}
}
