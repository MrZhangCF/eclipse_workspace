package pojo;

import java.sql.Date;

public class Slr {
	private Date DATE	;
	private Integer SLR;
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date date) {
		this.DATE = date;
	}
	public Integer getSLR() {
		return SLR;
	}
	public void setSLR(Integer slr) {
		this.SLR = slr;
	}
	
	@Override
	public String toString() {
		return DATE.toString() + " : " + SLR;
	}
}
