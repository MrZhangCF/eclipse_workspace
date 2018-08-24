package cn.zhangcf.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.zhangcf.demo.EmpAction;

/**
 * �������Ҫ�����Ǹ����������Ƶ�����Ӧ���е�setter��getter����
 * 
 * @author zhangcf
 */
public class ObjectUtils {
	private ObjectUtils() {
	}

	/**
	 * ���ݶ����ָ������������ȡ��Field������Ϣ
	 * @param wrapObject
	 * @param attribute
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static Field getObjectField(Object wrapObject, String attribute) throws NoSuchFieldException, SecurityException{
		Field field = wrapObject.getClass().getDeclaredField(attribute); // �ڱ�������
		if(field == null){
			field = wrapObject.getClass().getField(attribute); //�ڸ�������
		}
		return field;
	}
	/**
	 * �������ָ�����е�getter����
	 * @param wrapObject ��ʾҪ���õķ�������������� 
	 * @param attr ��ʾ�������� 
	 * @return ���ö���Ľ��
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
		if(obj == null){  //��ʾû��ʵ�������󣬱����Լ��ֹ�ʵ��������
			obj = field.getType().newInstance();
			setObjectValue(wrapObject, attr, obj);
		}
		
		return obj;
	}

	/**
	 * ����ָ�������������ָ�����е����ԣ�����setter����
	 * @param wrapObject �����������ʵ��������
	 * @param attr ��������
	 * @param value ���Ե�ֵ
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void setObjectValue(Object wrapObject, String attr, Object value) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//�ж������Ƿ����
		Field field = getObjectField(wrapObject, attr);
		if(field == null){
			return ;
		}
		String methodName = "set" + StringUtils.initCap(attr);
		Method method = wrapObject.getClass().getMethod(methodName, field.getType());
		method.invoke(wrapObject, value);
	}
			
}
