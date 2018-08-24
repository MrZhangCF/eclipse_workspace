package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		sessionMap.put("username", this.username);
		
		//验证用户
		if(CheckUser.isUser(username, password)){
			return SUCCESS;
		}
		return LOGIN;
	}
}
