package cn.zhangcf.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class Personl implements Serializable {
	
	private String name;
	private int age;

	public Personl(String name, int age) {
		this.name = name;
		this.age = age;
	}

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


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class Serialization {
	public static final File FILE = new File("d:" + File.separator + "person.ser");

	public static void main(String[] args) throws Exception {
		ser(new Personl("张三", 20));
		dser();
	}
	
	/**
	 * 实现序列化
	 * @param obj 需要实例化的类对象
	 * @throws Exception
	 */
	public static void ser(Object obj) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
		oos.writeObject(obj);
		oos.close();
	}
	
	/**
	 * 实现反序列化
	 * @throws Exception
	 */
	public static void dser() throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
		Personl per = (Personl) ois.readObject();
		System.out.println(per.getName());
		System.out.println(per.getAge());
		ois.close();
	}
}
