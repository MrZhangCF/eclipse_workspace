package cn.zhangcf.utils;

/**
 * 本类主要负责实现自动的VO匹配处理操作，本身不需要通过实例化完成
 * @author zhangcf
 */
public class BeanOperation {
	private BeanOperation() {
	}

	/**
	 * 负责设置类中的属性操作
	 * 
	 * @param actionObject
	 *            表示当前发出设置请求的程序类的当前对象
	 * @param msg
	 *            所有的属性的具体内容，格式“属性名称：内容|属性名称：内容|...”
	 * @throws Exception
	 * @throws NoSuchMethodException
	 */
	public static void setBeanValue(Object actionObject, String msg) throws NoSuchMethodException, Exception {
		// 如果要想进行内容的设置，那么必须要求将字符串拆分（此处不关心验证）
		String result[] = msg.split("\\|"); // 按竖线拆分
		for (int x = 0; x < result.length; x++) { // 此处的格式为“属性名称：内容”
			String temp[] = result[x].split(":",2);
			String attr = temp[0]; // 属性名称，包括了“XxxAction”的属性和具体的简单Java类的属性
			String fields[] = attr.split("\\.");
			if (fields.length > 2) { // 多级配置 e.g. emp.dept.company.name
				
				Object currentObject = actionObject; //确定当前要操作的类的对象
				for (int y = 0; y < fields.length - 1; y++) { //对应的事getter的返回对象
					currentObject = ObjectUtils.getObject(currentObject, fields[y]);		
				}
				Object value = ObjectValueUtils.getValue(currentObject, fields[fields.length - 1], temp[1]);
				ObjectUtils.setObjectValue(currentObject, fields[fields.length - 1], value);
			} else { // 单级配置
				Object currentObject = ObjectUtils.getObject(actionObject, fields[0]);
				Object value = ObjectValueUtils.getValue(currentObject, fields[1], temp[1]);
				ObjectUtils.setObjectValue(currentObject, fields[1], value);
			}
		}
	}
}
