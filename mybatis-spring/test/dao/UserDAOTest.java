package dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.UserMapper;
import pojo.User;

public class UserDAOTest {

	private ApplicationContext ac;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
	}
	
	@Test
	public void testGetUserById() {
		//UserDAO ud = (UserDAO) ac.getBean("userDAOImpl");
		UserMapper ud = ac.getBean(UserMapper.class);
		User user = ud.getUserById(24);
		System.out.println("=======================");
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() {
		
	}

}
