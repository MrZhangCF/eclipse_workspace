package mapper;

import java.util.List;

import pojo.QueryVo;
import pojo.User;

public interface UserMapper {
	User getUserById(int id);
	List<User> getUserByName(String username);
	void insertUser(User user);
	User getUserByQueryVo(QueryVo queryVo);
}
