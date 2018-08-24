package design_pattern.singleton;

/**
 * ʹ��static�������ʵ�ֵ������ģʽ���ܹ���֤�̵߳İ�ȫ��
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
