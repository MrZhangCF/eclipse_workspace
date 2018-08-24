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
		//�ж��쳣������
		if(exception instanceof CustomerException){
			CustomerException cusExp = (CustomerException)exception;
			//ȡ��������Ϣ
			msg = cusExp.getExpMessage();
		}else{
			//����̨��ӡ��ջ��Ϣ
			exception.printStackTrace();
			StringWriter s = new StringWriter();
			PrintWriter printWriter = new PrintWriter(s);
			exception.printStackTrace(printWriter);
			msg = s.toString();
		}
		
		//�˴�������д��־�������ţ����ʼ�
		
		//����һ���ѺõĴ���ҳ�棬����ʾ������Ϣ
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("error");
		
		return modelAndView;
	}
	
}
