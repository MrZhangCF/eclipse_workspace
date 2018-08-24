package design_pattern.singleton;

import java.io.Serializable;

/**
 * 基于内部类实现的多线程情景下的单例模式
 * 缺点：在序列化和反序列化处理中，不能保证单例
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
