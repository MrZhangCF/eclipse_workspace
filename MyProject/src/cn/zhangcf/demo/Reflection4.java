package cn.zhangcf.demo;

import java.sql.Date;

//���䲻������ʵ�������󣬷��仹����ʵ�ֶ����һ�в���,����һ�ж�����ͨ��Object��ʵ�֡�

//ͨ������ȡ�ø���,���ӿڣ�

public class Reflection4 {
	public static void main(String[] args) {
		Class<?> cls = Date.class;
		System.out.println(cls.getPackage().getName());
		System.out.println(cls.getSuperclass().getName());
		
		Class<?> inf [] = cls.getInterfaces();
		System.out.println(inf.length);
		for(int x = 0;x < inf.length; x++){
			System.out.println(inf[x].getName());
		}
	}
}
