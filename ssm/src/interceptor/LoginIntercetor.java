package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercetor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Interceptor1 afterComletion......");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Interceptor1 postHandle......");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURL().toString();
		if (uri.contains("login")) {
			return true;
		}
		System.out.println("Interceptor1 preHandle......");
		HttpSession session = request.getSession();
		Object username = session.getAttribute("username");
		if (username != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath() + "/user/showlogin");
		return false;
	}
}
