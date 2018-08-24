package cn.zhangcf.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//使用反射来使用类的构造方法，普通方法和成员

class Person{
	private String name;
	private int age;
	
	public Person() throws RuntimeException {}
	public Person(String name) {}
	public Person(String name, int age) {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void print(String str){
		System.out.println(str);
	}
	
}

public class Reflection5 {
	public static void main(String[] args) throws Exception {
		//Class<?> cls = Person.class;
		Class<?> cls = Class.forName("cn.zhangcf.demo.Person");
		//使用反射调用构造方法
		
		Constructor<?> conts [] = cls.getConstructors();//使用反射取得构造函数时，类中必须含有无参构造，否则就要
													    //使用getConstructor(param, param);
		for(int x = 0; x < conts.length; x++){
			System.out.println(conts[x]);
		}
		
		for(int x = 0; x < conts.length; x++){
			System.out.println(conts[x].getName());
		}
		
		System.out.println("================================");
		
		//使用反射调用普通方法
		
		//取得一个类的全部普通方法：
		Method met [] = cls.getMethods();
		for(int x = 0; x < met.length; x++){
			System.out.println(met[x]);
		}
		
		System.out.println("---------------------------------");
		
		//取得一个类中的特定方法：
		Object obj = cls.newInstance();
		String attr = "name";
		String value = "zhangcf";
		//setName()是方法名称，但是这个方法名称是根据给定的属性信息拼凑得来的，同时
		//该方法需要两个参数信息
		Method setMethod = cls.getMethod("set" + initCap(attr), String.class);
		setMethod.invoke(obj, value);
		Method getMethod = cls.getMethod("get" + initCap(attr));
		Object retu = getMethod.invoke(obj);
		System.out.println(retu);
		
		System.out.println("================================");
		
		//反射调用类成员
		Field nameField = cls.getDeclaredField("name");
		nameField.setAccessible(true); //取消封装
		nameField.set(obj, "zhangsan");
		System.out.println(nameField.get(obj));
		
		//Field类中的一个很有用的方法：获取属性类型
		System.out.println(nameField.getType().getName());
		System.out.println(nameField.getType().getSimpleName());
		
	}
	
	public static String initCap(String str){
		
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
