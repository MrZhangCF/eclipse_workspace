package cn.zhangcf.demo;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //表示此annotation在运行时生效
@interface MyAnnotation{ //定义了一个自己的Annotation
	public String name();  //表示定义了一个属性
	public int age();
	public String school() default "wuhanU";  //可以使用default关键字定义属性的默认值
	
}

@SuppressWarnings("serial")
@MyAnnotation(name="zhangcf",age = 10)
class AnnotationTest implements Serializable{
	
}
public class AnnotationDemo {
	public static void main(String[] args) throws Exception{
		Annotation ant [] = AnnotationTest.class.getAnnotations();
		for(int x = 0; x < ant.length; x++){
			System.out.println(ant[x]); //取得全部的Annotation信息
		}
		
		//以下可以获取Annotation中的特定的属性信息
		MyAnnotation mant = AnnotationTest.class.getDeclaredAnnotation(MyAnnotation.class);
		System.out.println(mant.name());
		System.out.println(mant.age());
		System.out.println(mant.school());
	}
}
