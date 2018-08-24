package cn.zhangcf.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//代理设计模式第二版：动态设计模式
//核心本质：一个代理类可以代理所有需要待代理的接口
interface ISubjectt{
	public void eat(String msg, int num);
}
class RealSubjectt implements ISubjectt{

	@Override
	public void eat(String msg, int num) {
		// TODO Auto-generated method stub
		System.out.println("我要吃" + num + "份" + msg);
	}
	
}
//实现InvocationHandler接口表示该代理类为动态代理类，其中InvocationHandler是一个标识接口
class ProxySubjectt implements InvocationHandler{
	private Object target;  //表示绑定任何接口的对象，所以使用Object表示；
	/**
	 * 实现真实对象的绑定处理，同时返回代理对象
	 * @param target
	 * @return 返回一个代理对象
	 */
	public Object bind(Object target){
		this.target = target;  //保存真实类对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	public void prepare(){
		System.out.println("准备食材");
	}
	public void clear(){
		System.out.println("收拾桌子");
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
		subject.eat("米饭", 10);
	}
}
