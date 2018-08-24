package action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class UserLoginInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		if(LoginAction.class == arg0.getAction().getClass()){
			arg0.invoke();
		}
		Map<String, Object> sessionMap = arg0.getInvocationContext().getSession();
		if(null == sessionMap.get("username")){
			return Action.LOGIN;
		}
		return arg0.invoke();
	}
}
