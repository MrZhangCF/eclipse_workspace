package design_pattern.singleton;
/**
 * �򵥵ĵ���ģʽ����֤һ�������һ��ʵ�������ṩһ����������ȫ�ַ��ʵ㡣
 * ʹ�ó�������ϵͳ��Ҫһ����ֻ��һ��ʵ����ʱ��
 * �׶ˣ��ü򵥵ĵ���ģʽ�������ڶ��̡߳�
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
