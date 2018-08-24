package cn.zhangcf.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//�������ģʽ�ڶ��棺��̬���ģʽ
//���ı��ʣ�һ����������Դ���������Ҫ������Ľӿ�
interface ISubjectt{
	public void eat(String msg, int num);
}
class RealSubjectt implements ISubjectt{

	@Override
	public void eat(String msg, int num) {
		// TODO Auto-generated method stub
		System.out.println("��Ҫ��" + num + "��" + msg);
	}
	
}
//ʵ��InvocationHandler�ӿڱ�ʾ�ô�����Ϊ��̬�����࣬����InvocationHandler��һ����ʶ�ӿ�
class ProxySubjectt implements InvocationHandler{
	private Object target;  //��ʾ���κνӿڵĶ�������ʹ��Object��ʾ��
	/**
	 * ʵ����ʵ����İ󶨴���ͬʱ���ش������
	 * @param target
	 * @return ����һ���������
	 */
	public Object bind(Object target){
		this.target = target;  //������ʵ�����
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	public void prepare(){
		System.out.println("׼��ʳ��");
	}
	public void clear(){
		System.out.println("��ʰ����");
	}
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
//		System.out.println(arg0.getClass());
//		System.out.println(arg1);
//		System.out.println(Arrays.toString(arg2));
		this.prepare();
		Object ret = arg1.invoke(this.target, arg2);
		this.clear();
		return ret;
	}
	
}
public class ActingDesignPattern2 {
	public static void main(String[] args) {
		ISubjectt subject = (ISubjectt) new ProxySubjectt().bind(new RealSubjectt());
		subject.eat("�׷�", 10);
	}
}
