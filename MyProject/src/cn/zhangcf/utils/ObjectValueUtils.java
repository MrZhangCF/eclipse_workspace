package cn.zhangcf.utils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 本类的功能是将字符串的内容根据属性对应的类型变为各种数据类型
 * 支持int(Integer),double(Double),long(Long),String,Date
 * 其中Date必须考虑日期时间和日期
 * @author zhangcf
 */
public class ObjectValueUtils {
	private ObjectValueUtils(){}
	/**
	 * 负责将传入的字符串变为与指定属性类型相符合的数据类型
	 * @param wrapObject 待处理的类对象
	 * @param attribute 参数名称
	 * @param value 要处理的值
	 * @return 转换后的值
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
	 * 根据指定的类型将字符串进行转型处理
	 * @param type 数据类型
	 * @param value 数据内容
	 * @return 转换为具体类型
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
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	private static boolean isNotEmpty(String str){
		return !(str == null || str.isEmpty() || "".equals(str));
	}
	/**
	 * 判断一个字符串是否是一个整数
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
	 * 判断字符串是否是小数
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
	 * 判断是否为日期
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
	 * 判断是否为日期时间
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
