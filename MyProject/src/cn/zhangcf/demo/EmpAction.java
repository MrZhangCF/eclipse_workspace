package cn.zhangcf.demo;

import cn.zhangcf.utils.BeanOperation;

public class EmpAction {
	Emp emp = new Emp();
	public void setValue(String val){
		//这里传入this，主要是将EmpAction的类对象传递到方法里面
		//因为给定的标记：emp.ename:smith,而emp应该对应的是getEmp()方法
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
