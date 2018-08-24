package pojo;

import java.sql.Date;

public class Hmd {
	private Date DATE;
	private Double HMD;
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date date) {
		this.DATE = date;
	}
	public Double getHMD() {
		return HMD;
	}
	public void setHMD(Double hmd) {
		this.HMD = hmd;
	}
	
	@Override
	public String toString() {
		return DATE.toString() + " : " + HMD.toString();
	}
}
