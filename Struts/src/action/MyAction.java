package action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MyAction extends ActionSupport {
	private int num1;
	private int num2;
	
	private int n1;
	private int n2;
	@Override
	public String execute() throws Exception {
		if(this.getSum() >= 0){
			return "Positive";
		}else{
			return "Negative";
		}
	}
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getSum(){
		return n1 + n2;
	}

	@Override
	public void validate() {
		try{
			n1 = Integer.valueOf(num1);
		}catch(Exception e){
			addFieldError("num1", "num1 is not Number");
		}
		try{
			n2 = Integer.valueOf(num2);
		}catch(Exception e){
			addFieldError("num2", "num2 is not Number");
		}

	}
	
	
}
