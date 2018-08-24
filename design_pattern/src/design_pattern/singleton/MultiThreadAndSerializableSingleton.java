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
	
	//该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
	public Object readResolve() throws ObjectStreamException{
		System.out.println("调用了readResolve方法");
		return MultiThreadAndSerializableSingletonHandler.instance;
	}
}
