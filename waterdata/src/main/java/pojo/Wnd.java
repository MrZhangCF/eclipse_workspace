package pojo;

import java.sql.Date;

public class Wnd {
	private Date DATE;
	private Double WND;
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
	public Double getWND() {
		return WND;
	}
	public void setWND(Double wND) {
		WND = wND;
	}
	
	@Override
	public String toString() {
		return DATE.toString() + " : " + WND;
	}
}
