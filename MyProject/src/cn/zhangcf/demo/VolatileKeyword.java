package cn.zhangcf.demo;

//volatile�ؼ��ֵ�ʹ������
//δʹ��volatile�ؼ��ֶ���ı������������ʱ��ʹ�õ��Ǹ������еĴ���������ԭʼ����
//֮���ͬ���ͻ�����ӳ٣���ν���̵߳Ĳ�ͬ��Ҳ�����ڴ�
//volatile�ؼ��ֶ���ı�����ʾ��ֱ��ʹ��ԭʼ���ݽ��д������ĺ�ֱ����Ч��

class Singleton {
	private volatile static Singleton instance;

	private Singleton() {
		System.out.println("�����췽����" + Thread.currentThread().getName());
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}

public class VolatileKeyword {
	public static void main(String[] args) {
		new Thread(() -> Singleton.getInstance(), "�߳�A").start();
		new Thread(() -> Singleton.getInstance(), "�߳�B").start();
		new Thread(() -> Singleton.getInstance(), "�߳�C").start();
		new Thread(() -> Singleton.getInstance(), "�߳�D").start();
		new Thread(() -> Singleton.getInstance(), "�߳�E").start();
		// ִ�������Ĵ��뷢�ֵ������ģʽ�����ǵ���
		// ��һ�ַ�����������Singleton���е�getInstance()����ǰ����synchronized�ؼ���
		// �ڶ��ַ���������
	}
}
