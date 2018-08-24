package cn.zhangcf.utils;
/**
 * 针对字符串尽心处理操作
 * @author zhangcf
 *
 */
public class StringUtils {
	private StringUtils(){}
	/**
	 * 首字母大写
	 * @param str 要处理的字符串
	 * @return 首字母大写
	 */
	public static String initCap(String str){
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
