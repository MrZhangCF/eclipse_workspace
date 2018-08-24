package cn.zhangcf.demo;

import java.util.Date;

//认识反射机制
public class Reflection {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		System.out.println(date.getClass());
		
		//以下是三种获取对象所属类的方法
		
		//Class对象的第一种实例化模式：
		//这里的泛型一般都是用?来写
		Class<?> cls = new Date().getClass();
		System.out.println(cls.getName());
		
		//Class对象的第二种实例化模式：
		Class<?> cls2 = Date.class;
		System.out.println(cls2.getName());
		
		//Class对象的第三种实例化模式：
		Class<?> cls3 = Class.forName("java.util.Date");
		System.out.println(cls3.getName());
		
		//在获得对象所属的类之后，可以通过反射来进行实例化对象
		Object obj = cls.newInstance();
		System.out.println(obj);
	}
}
