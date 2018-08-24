package cn.zhangcf.demo;

public class Reflection6 {
	public static void main(String[] args) {
		String value = "emp.ename:smith|emp.job:clerk|emp.salary:1999.12|emp.hireDate:1999-10-10|"+
				"emp.dept.dname:财务部|emp.dept.loc:广州|emp.dept.count:1589466|" + 
				"emp.dept.company.cid:10|emp.dept.company.name:Tencent|emp.dept.company.address:深圳|emp.dept.company.creat:1995-01-14 19:19:19";
		EmpAction action = new EmpAction();
		action.setValue(value);
		System.out.println(action.getEmp());
	}
}
