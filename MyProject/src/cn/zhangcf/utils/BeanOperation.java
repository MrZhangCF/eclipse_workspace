package cn.zhangcf.utils;

/**
 * ������Ҫ����ʵ���Զ���VOƥ�䴦�������������Ҫͨ��ʵ�������
 * @author zhangcf
 */
public class BeanOperation {
	private BeanOperation() {
	}

	/**
	 * �����������е����Բ���
	 * 
	 * @param actionObject
	 *            ��ʾ��ǰ������������ĳ�����ĵ�ǰ����
	 * @param msg
	 *            ���е����Եľ������ݣ���ʽ���������ƣ�����|�������ƣ�����|...��
	 * @throws Exception
	 * @throws NoSuchMethodException
	 */
	public static void setBeanValue(Object actionObject, String msg) throws NoSuchMethodException, Exception {
		// ���Ҫ��������ݵ����ã���ô����Ҫ���ַ�����֣��˴���������֤��
		String result[] = msg.split("\\|"); // �����߲��
		for (int x = 0; x < result.length; x++) { // �˴��ĸ�ʽΪ���������ƣ����ݡ�
			String temp[] = result[x].split(":",2);
			String attr = temp[0]; // �������ƣ������ˡ�XxxAction�������Ժ;���ļ�Java�������
			String fields[] = attr.split("\\.");
			if (fields.length > 2) { // �༶���� e.g. emp.dept.company.name
				
				Object currentObject = actionObject; //ȷ����ǰҪ��������Ķ���
				for (int y = 0; y < fields.length - 1; y++) { //��Ӧ����getter�ķ��ض���
					currentObject = ObjectUtils.getObject(currentObject, fields[y]);		
				}
				Object value = ObjectValueUtils.getValue(currentObject, fields[fields.length - 1], temp[1]);
				ObjectUtils.setObjectValue(currentObject, fields[fields.length - 1], value);
			} else { // ��������
				Object currentObject = ObjectUtils.getObject(actionObject, fields[0]);
				Object value = ObjectValueUtils.getValue(currentObject, fields[1], temp[1]);
				ObjectUtils.setObjectValue(currentObject, fields[1], value);
			}
		}
	}
}
