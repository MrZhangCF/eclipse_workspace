package cn.zhangcf.demo;

import java.util.Date;

public class Company {
	private Integer cid;
	private String name;
	private String address;
	private Date creat;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreat() {
		return creat;
	}
	public void setCreat(Date creat) {
		this.creat = creat;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Company [cid=" + cid + ", name=" + name + ", address=" + address + ", creat=" + creat + "]";
	}
	
}
