package design_pattern.singleton;
/**
 * 简单的单例模式：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 使用场景：当系统需要一个类只有一个实例的时候。
 * 弊端：该简单的单例模式不适用于多线程。
 * @author zhangcf
 *
 */
public class SimpleSingleton {
	private static SimpleSingleton instance;
	private SimpleSingleton(){}
	public static SimpleSingleton getInstance(){
		if(instance == null)
			instance = new SimpleSingleton();
		return instance;
	}
}
