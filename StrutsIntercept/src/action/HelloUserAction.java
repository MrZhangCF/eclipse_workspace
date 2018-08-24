package action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class HelloUserAction extends ActionSupport{
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
}
