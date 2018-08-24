package cn.zhangcf.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.zhangcf.demo.EmpAction;

/**
 * 本类的主要功能是根据属性名称调用相应类中的setter，getter方法
 * 
 * @author zhangcf
 */
public class ObjectUtils {
	private ObjectUtils() {
	}

	/**
	 * 根据对象和指定的属性名称取得Field对象信息
	 * @param wrapObject
	 * @param attribute
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static Field getObjectField(Object wrapObject, String attribute) throws NoSuchFieldException, SecurityException{
		Field field = wrapObject.getClass().getDeclaredField(attribute); // 在本类中找
		if(field == null){
			field = wrapObject.getClass().getField(attribute); //在父类中找
		}
		return field;
	}
	/**
	 * 负责调用指定类中的getter方法
	 * @param wrapObject 表示要调用的方法的所在类对象 
	 * @param attr 表示属性名称 
	 * @return 调用对象的结果
	 * @throws Exception
	 * @throws NoSuchMethodException
	 */
	public static Object getObject(Object wrapObject, String attr) throws NoSuchMethodException, Exception {
		String methodName = "get" + StringUtils.initCap(attr);
		Field field = getObjectField(wrapObject, attr);
		if(field == null){
			return null;
		}
		Method method = wrapObject.getClass().getMethod(methodName);
		Object obj = method.invoke(wrapObject);
		if(obj == null){  //表示没有实例化对象，必须自己手工实例化对象
			obj = field.getType().newInstance();
			setObjectValue(wrapObject, attr, obj);
		}
		
		return obj;
	}

	/**
	 * 根据指定的类对象设置指定类中的属性，调用setter方法
	 * @param wrapObject 属性所在类的实例化对象
	 * @param attr 属性名称
	 * @param value 属性的值
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void setObjectValue(Object wrapObject, String attr, Object value) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//判断属性是否存在
		Field field = getObjectField(wrapObject, attr);
		if(field == null){
			return ;
		}
		String methodName = "set" + StringUtils.initCap(attr);
		Method method = wrapObject.getClass().getMethod(methodName, field.getType());
		method.invoke(wrapObject, value);
	}
			
}
