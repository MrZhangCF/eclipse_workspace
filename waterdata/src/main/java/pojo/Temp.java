package pojo;

import java.sql.Date;

public class Temp {
	private Date DATE;
	private Integer MAX;
	private Integer MIN;
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
	public Integer getMAX() {
		return MAX;
	}
	public void setMAX(Integer mAX) {
		MAX = mAX;
	}
	public Integer getMIN() {
		return MIN;
	}
	public void setMIN(Integer mIN) {
		MIN = mIN;
	}
	
	@Override
	public String toString() {
		return DATE.toString() + " : " + MAX + " , " + MIN;
	}
}
