package cn.zhangcf.demo;

import java.util.Date;

//��ʶ�������
public class Reflection {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		System.out.println(date.getClass());
		
		//���������ֻ�ȡ����������ķ���
		
		//Class����ĵ�һ��ʵ����ģʽ��
		//����ķ���һ�㶼����?��д
		Class<?> cls = new Date().getClass();
		System.out.println(cls.getName());
		
		//Class����ĵڶ���ʵ����ģʽ��
		Class<?> cls2 = Date.class;
		System.out.println(cls2.getName());
		
		//Class����ĵ�����ʵ����ģʽ��
		Class<?> cls3 = Class.forName("java.util.Date");
		System.out.println(cls3.getName());
		
		//�ڻ�ö�����������֮�󣬿���ͨ������������ʵ��������
		Object obj = cls.newInstance();
		System.out.println(obj);
	}
}
