package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value="/user/showlogin")
	public String showLogin(){
		return "login";
	}
	@RequestMapping(value="/user/login")
	public String userLogin(String username,String password,HttpSession session){
		System.out.println(username);
		System.out.println(password);
		session.setAttribute("username", username);
		return "redirect:/itemlist";
	}
}
