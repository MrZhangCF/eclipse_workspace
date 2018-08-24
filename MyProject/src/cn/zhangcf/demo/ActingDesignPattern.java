package cn.zhangcf.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//��һ�� �������ģʽ:���A�����OӋģʽ

interface ISubject{  //������Ƶĺ���������Ҫһ�����ĵĽӿ�
	public void eat();
}

class RealSubject implements ISubject{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("����һ��Ҫ�Է���");
	}
}

class ProxySubject implements ISubject{
	private ISubject subject;
	public ProxySubject(ISubject subject){
		this.subject = subject;
	}
	public void prepare(){
		System.out.println("��Ҫ׼��ʳ��");
	}
	public void clear(){
		System.out.println("ϴˢ���");
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		this.prepare();
		this.subject.eat();
		this.clear();
	}
}

class Factoryyy{
	private Factoryyy(){}
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className){
		T t = null;
		try {
			t = (T)Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
//	@SuppressWarnings("unchecked")
//	public static <T> T getInstance(String className, Object obj) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//		T t = null;
//		Constructor<?> cons = Class.forName(className).getConstructor(obj.getClass().getInterfaces()[0]);
//		t = (T)cons.newInstance(obj);
//		return t;
//	}
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String proxyClassName, String realClassName) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		T t = null;
		T obj = getInstance(realClassName);
		Constructor<?> cons = Class.forName(proxyClassName).getConstructor(obj.getClass().getInterfaces()[0]);
		t = (T)cons.newInstance(obj);
		return t;
	}
}
public class ActingDesignPattern {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//ISubject subject = Factoryyy.getInstance("cn.zhangcf.demo.ProxySubject", Factoryyy.getInstance("cn.zhangcf.demo.RealSubject"));
		ISubject subject = Factoryyy.getInstance("cn.zhangcf.demo.ProxySubject", "cn.zhangcf.demo.RealSubject");
		subject.eat();
	}
}
