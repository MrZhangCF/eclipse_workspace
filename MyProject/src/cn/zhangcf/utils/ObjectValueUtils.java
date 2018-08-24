package cn.zhangcf.utils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * ����Ĺ����ǽ��ַ��������ݸ������Զ�Ӧ�����ͱ�Ϊ������������
 * ֧��int(Integer),double(Double),long(Long),String,Date
 * ����Date���뿼������ʱ�������
 * @author zhangcf
 */
public class ObjectValueUtils {
	private ObjectValueUtils(){}
	/**
	 * ���𽫴�����ַ�����Ϊ��ָ��������������ϵ���������
	 * @param wrapObject ������������
	 * @param attribute ��������
	 * @param value Ҫ�����ֵ
	 * @return ת�����ֵ
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws ParseException 
	 */
	public static Object getValue(Object wrapObject, String attribute, String value) throws NoSuchFieldException, SecurityException, ParseException{
		Field field = ObjectUtils.getObjectField(wrapObject, attribute);
		if(field == null){
			return null;
		}
		return stringToType(field.getType().getSimpleName(), value);
	}
	/**
	 * ����ָ�������ͽ��ַ�������ת�ʹ���
	 * @param type ��������
	 * @param value ��������
	 * @return ת��Ϊ��������
	 * @throws ParseException 
	 */
	private static Object stringToType(String type, String value) throws ParseException{
		if("String".equals(type)){
			if(isNotEmpty(value)){
				return value;
			}else{
				return null;
			}
		}else if("int".equals(type) || "Integer".equals(type)){
			if(isInt(value)){
				return Integer.parseInt(value);
			}
		}else if("double".equals(type) || "Double".equals(type)){
			if(isDouble(value)){
				return Double.parseDouble(value);
			}
		}else if("long".equals(type) || "Long".equals(type)){
			if(isInt(value)){
				return Long.parseLong(value);
			}
		}else if("Date".equals(type)){
			String pattern = null;
			if(isDate(value)){
				pattern = "yyyy-MM-dd";
				return new SimpleDateFormat(pattern).parse(value);
			}else if(isDateTime(value)){
				pattern = "yyyy-MM-dd hh:mm:ss";
				return new SimpleDateFormat(pattern).parse(value);
			}
//			if(pattern != null){
//				return new SimpleDateFormat(pattern).parse(value);
//			}
		}
		return null;
	}
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	private static boolean isNotEmpty(String str){
		return !(str == null || str.isEmpty() || "".equals(str));
	}
	/**
	 * �ж�һ���ַ����Ƿ���һ������
	 * @param str
	 * @return
	 */
	private static boolean isInt(String str){
		if(isNotEmpty(str)){
			return str.matches("\\d+");
		}
		return false;
	}
	/**
	 * �ж��ַ����Ƿ���С��
	 * @param str
	 * @return
	 */
	private static boolean isDouble(String str){
		if(isNotEmpty(str)){
			return str.matches("\\d+(\\.\\d+)?");
		}
		return false;
	}
	/**
	 * �ж��Ƿ�Ϊ����
	 * @param str
	 * @return
	 */
	private static boolean isDate(String str){
		if(isNotEmpty(str)){
			return str.matches("\\d{4}\\-\\d{2}\\-\\d{2}");
		}
		return false;
	}
	/**
	 * �ж��Ƿ�Ϊ����ʱ��
	 * @param str
	 * @return
	 */
	private static boolean isDateTime(String str){
		if(isNotEmpty(str)){
			return str.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
		}
		return false;
	}
}
