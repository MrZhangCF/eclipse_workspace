package design_pattern.singleton;

/**
 * 使用static代码块来实现单例设计模式，能够保证线程的安全性
 * @author zhangcf
 *
 */
public class StaticSingleton {
	private static StaticSingleton instance = null;
	
	private StaticSingleton(){}
	
	static {
		instance = new StaticSingleton();
	}
	
	public static StaticSingleton getInstance(){
		return instance;
	}
}
