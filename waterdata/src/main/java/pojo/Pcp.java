package pojo;

import java.sql.Date;

public class Pcp {
	private Date DATE;
	private Double PCP;
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date date) {
		this.DATE = date;
	}
	public Double getPCP() {
		return PCP;
	}
	public void setPCP(Double pcp) {
		this.PCP = pcp;
	}
	
	@Override
	public String toString() {
		return DATE.toString() + " : " + PCP;
	}
}
