package cn.zhangcf.demo;

import cn.zhangcf.utils.BeanOperation;

public class EmpAction {
	Emp emp = new Emp();
	public void setValue(String val){
		//���ﴫ��this����Ҫ�ǽ�EmpAction������󴫵ݵ���������
		//��Ϊ�����ı�ǣ�emp.ename:smith,��empӦ�ö�Ӧ����getEmp()����
		try {
			BeanOperation.setBeanValue(this, val);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Emp getEmp(){
		return emp;
	}
}
