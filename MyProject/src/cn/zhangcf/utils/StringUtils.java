package cn.zhangcf.utils;
/**
 * ����ַ������Ĵ������
 * @author zhangcf
 *
 */
public class StringUtils {
	private StringUtils(){}
	/**
	 * ����ĸ��д
	 * @param str Ҫ������ַ���
	 * @return ����ĸ��д
	 */
	public static String initCap(String str){
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
