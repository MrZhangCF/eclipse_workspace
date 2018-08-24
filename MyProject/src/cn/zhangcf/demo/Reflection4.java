package cn.zhangcf.demo;

import java.sql.Date;

//反射不仅可以实例化对象，反射还可以实现对象的一切操作,而这一切都可以通过Object类实现。

//通过反射取得父类,父接口：

public class Reflection4 {
	public static void main(String[] args) {
		Class<?> cls = Date.class;
		System.out.println(cls.getPackage().getName());
		System.out.println(cls.getSuperclass().getName());
		
		Class<?> inf [] = cls.getInterfaces();
		System.out.println(inf.length);
		for(int x = 0;x < inf.length; x++){
			System.out.println(inf[x].getName());
		}
	}
}
