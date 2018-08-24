package design_pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MultiThreadAndSerializableSingleton implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private MultiThreadAndSerializableSingleton(){}
	
	private static class MultiThreadAndSerializableSingletonHandler{
		private static MultiThreadAndSerializableSingleton instance = new MultiThreadAndSerializableSingleton();
	}
	
	public static MultiThreadAndSerializableSingleton getInstance(){
		return MultiThreadAndSerializableSingletonHandler.instance;
	}
	
	//�÷����ڷ����л�ʱ�ᱻ���ã��÷������ǽӿڶ���ķ������е��Լ���׳ɵĸо�
	public Object readResolve() throws ObjectStreamException{
		System.out.println("������readResolve����");
		return MultiThreadAndSerializableSingletonHandler.instance;
	}
}
