package cn.zhangcf.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//ʹ�÷�����ʹ����Ĺ��췽������ͨ�����ͳ�Ա

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
		//ʹ�÷�����ù��췽��
		
		Constructor<?> conts [] = cls.getConstructors();//ʹ�÷���ȡ�ù��캯��ʱ�����б��뺬���޲ι��죬�����Ҫ
													    //ʹ��getConstructor(param, param);
		for(int x = 0; x < conts.length; x++){
			System.out.println(conts[x]);
		}
		
		for(int x = 0; x < conts.length; x++){
			System.out.println(conts[x].getName());
		}
		
		System.out.println("================================");
		
		//ʹ�÷��������ͨ����
		
		//ȡ��һ�����ȫ����ͨ������
		Method met [] = cls.getMethods();
		for(int x = 0; x < met.length; x++){
			System.out.println(met[x]);
		}
		
		System.out.println("---------------------------------");
		
		//ȡ��һ�����е��ض�������
		Object obj = cls.newInstance();
		String attr = "name";
		String value = "zhangcf";
		//setName()�Ƿ������ƣ�����������������Ǹ��ݸ�����������Ϣƴ�յ����ģ�ͬʱ
		//�÷�����Ҫ����������Ϣ
		Method setMethod = cls.getMethod("set" + initCap(attr), String.class);
		setMethod.invoke(obj, value);
		Method getMethod = cls.getMethod("get" + initCap(attr));
		Object retu = getMethod.invoke(obj);
		System.out.println(retu);
		
		System.out.println("================================");
		
		//����������Ա
		Field nameField = cls.getDeclaredField("name");
		nameField.setAccessible(true); //ȡ����װ
		nameField.set(obj, "zhangsan");
		System.out.println(nameField.get(obj));
		
		//Field���е�һ�������õķ�������ȡ��������
		System.out.println(nameField.getType().getName());
		System.out.println(nameField.getType().getSimpleName());
		
	}
	
	public static String initCap(String str){
		
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
