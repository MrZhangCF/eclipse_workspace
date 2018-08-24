package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pojo.User;

public class MybatisTest {
//	@Test
//	public void getUserById() throws IOException {
//		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
//		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//		SqlSessionFactory ssf = ssfb.build(inputStream);
//		SqlSession ss = ssf.openSession();
//		User user = ss.selectOne("getUserById", 10);
//		System.out.println("结果:" + user);
//		ss.close();
//	}
	
	private SqlSessionFactory ssf = null;
	
	@Before
	public void init() throws IOException{
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		ssf = ssfb.build(is);
	}
	//@Test
	public void getUserById(){
		SqlSession ss= ssf.openSession();
		User user = ss.selectOne("getUserById", 10);
		System.out.println(user);
		ss.close();
	}
	//@Test
	public void getUserByName(){
		SqlSession ss = ssf.openSession();
		List<User> list = ss.selectList("getUserByName", "%张%");
		for(User user:list){
			System.out.println(user);
		}
		ss.close();
	}
	@Test
	public void addUser(){
		SqlSession ss = ssf.openSession();
		User user = new User();
		user.setUserName("小乔");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("上海");
		ss.insert("insertUser", user);
		ss.commit();
		ss.close();
	}
}
