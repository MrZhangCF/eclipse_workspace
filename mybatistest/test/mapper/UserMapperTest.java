package mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pojo.QueryVo;
import pojo.User;

public class UserMapperTest {

	private SqlSessionFactory ssf = null;
	
	@Before
	public void init() throws IOException{
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		ssf = ssfb.build(is);
	}
	
	//@Test
	public void testGetUserById() {
		SqlSession ss = ssf.openSession();
		UserMapper userMapper = ss.getMapper(UserMapper.class);
		User user = userMapper.getUserById(10);
		System.out.println(user);
		ss.close();
	}

	@Test
	public void testGetUserByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetUserByQueryVo() {
	    SqlSession sqlSession = ssf.openSession();
	    // 获得mapper代理对象
	    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	    // 创建一个QueryVo对象
	    QueryVo queryVo = new QueryVo();
	    User user = new User();
	    user.setId(10);
	    queryVo.setUser(user);
	    // 执行查询
	    User result = userMapper.getUserByQueryVo(queryVo);
	    System.out.println(result);
	    sqlSession.close();
	}
}
