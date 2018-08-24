package exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		String msg = null;
		//判断异常的种类
		if(exception instanceof CustomerException){
			CustomerException cusExp = (CustomerException)exception;
			//取出错误信息
			msg = cusExp.getExpMessage();
		}else{
			//控制台打印堆栈信息
			exception.printStackTrace();
			StringWriter s = new StringWriter();
			PrintWriter printWriter = new PrintWriter(s);
			exception.printStackTrace(printWriter);
			msg = s.toString();
		}
		
		//此处还可以写日志，发短信，发邮件
		
		//返回一个友好的错误页面，并显示错误信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("error");
		
		return modelAndView;
	}
	
}
