package cn.zhangcf.demo;
//ºÚµ•java¿‡
public class Emp {
	private String ename;
	private String job;
	private Double salary;
	private java.util.Date hireDate;
	private Dept dept;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public java.util.Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
	}
	
	@Override
	public String toString() {
		return "Emp [ename=" + ename + ", job=" + job + ", salary=" + salary + ", hireDate=" + hireDate + ", dept="
				+ dept + "]";
	}
	
	
}
