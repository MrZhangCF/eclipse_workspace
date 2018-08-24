package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import pojo.User;

public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {

	@Override
	public User getUserById(Integer id) {
		SqlSession ss = getSqlSession();
		User user = ss.selectOne("test.getUserById", id);
		return user;
	}

	@Override
	public List<User> getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
