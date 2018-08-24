package cn.zhangcf.demo;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) //��ʾ��annotation������ʱ��Ч
@interface MyAnnotation{ //������һ���Լ���Annotation
	public String name();  //��ʾ������һ������
	public int age();
	public String school() default "wuhanU";  //����ʹ��default�ؼ��ֶ������Ե�Ĭ��ֵ
	
}

@SuppressWarnings("serial")
@MyAnnotation(name="zhangcf",age = 10)
class AnnotationTest implements Serializable{
	
}
public class AnnotationDemo {
	public static void main(String[] args) throws Exception{
		Annotation ant [] = AnnotationTest.class.getAnnotations();
		for(int x = 0; x < ant.length; x++){
			System.out.println(ant[x]); //ȡ��ȫ����Annotation��Ϣ
		}
		
		//���¿��Ի�ȡAnnotation�е��ض���������Ϣ
		MyAnnotation mant = AnnotationTest.class.getDeclaredAnnotation(MyAnnotation.class);
		System.out.println(mant.name());
		System.out.println(mant.age());
		System.out.println(mant.school());
	}
}
