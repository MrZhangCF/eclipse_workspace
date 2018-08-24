package cn.zhangcf.demo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//实现变态要求，不设置接口的代理设计模式
//使用cglib开发包实现

//基于类的代理实现
class Cglib{
	public void send(){
		System.out.println("www.zhangcf.demo");
	}
}

//MethodIntercepter表示定义一个拦截器
class MyProxy implements MethodInterceptor{
	private Object target;
	public MyProxy(Object target){  
		this.target = target;
	}
	public void prepare(){
		System.out.println("打开电脑");
	}
	public void clear(){
		System.out.println("关闭电源");
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
		Enhancer enhancer = new Enhancer();  //这是一个负责代理关系的操作程序类
		enhancer.setSuperclass(msg.getClass());//把本类的对象作为
		enhancer.setCallback(new MyProxy(msg));
		//以上就动态配置好了类之间的代理关系
		Cglib temp = (Cglib)enhancer.create();
		temp.send();
	}
}
