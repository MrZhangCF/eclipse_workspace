package design_pattern.singleton;

import java.io.Serializable;

/**
 * �����ڲ���ʵ�ֵĶ��߳��龰�µĵ���ģʽ
 * ȱ�㣺�����л��ͷ����л������У����ܱ�֤����
 * @author zhangcf
 *
 */
public class MultiThreadSingleton implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private MultiThreadSingleton(){};
	
	private static class MultiThreadSingletonHandler{
		private static MultiThreadSingleton instance = new MultiThreadSingleton();
	}
	
	public static  MultiThreadSingleton getInstance(){
		return MultiThreadSingletonHandler.instance;
	}
}
