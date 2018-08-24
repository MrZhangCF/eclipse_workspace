package cn.zhangcf.demo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//ʵ�ֱ�̬Ҫ�󣬲����ýӿڵĴ������ģʽ
//ʹ��cglib������ʵ��

//������Ĵ���ʵ��
class Cglib{
	public void send(){
		System.out.println("www.zhangcf.demo");
	}
}

//MethodIntercepter��ʾ����һ��������
class MyProxy implements MethodInterceptor{
	private Object target;
	public MyProxy(Object target){  
		this.target = target;
	}
	public void prepare(){
		System.out.println("�򿪵���");
	}
	public void clear(){
		System.out.println("�رյ�Դ");
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		this.prepare();
		Object ret = method.invoke(this.target, arg2);
		this.clear();
		return ret;
	}
	
}
public class ActingDesignPattern3 {
	public static void main(String[] args) {
		Cglib msg = new Cglib();
		Enhancer enhancer = new Enhancer();  //����һ����������ϵ�Ĳ���������
		enhancer.setSuperclass(msg.getClass());//�ѱ���Ķ�����Ϊ
		enhancer.setCallback(new MyProxy(msg));
		//���ϾͶ�̬���ú�����֮��Ĵ����ϵ
		Cglib temp = (Cglib)enhancer.create();
		temp.send();
	}
}
