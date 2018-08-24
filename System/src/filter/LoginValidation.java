package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidation implements Filter {

	private FilterConfig config;

	public static boolean isContains(String url, String[] regx) {
		boolean flag = false;
		for (int i = 0; i < regx.length; i++) {
			if (url.indexOf(regx[i]) != -1) {
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String redirectPath = request.getContextPath() + config.getInitParameter("redirectPath");
		String str = request.getRequestURI();
		System.out.println(str);
		System.out.println(request.getRequestURL());
		System.out.println(request.getServletPath());

	}

	@Override
	public void destroy() {
		this.config = null;
	}
}
