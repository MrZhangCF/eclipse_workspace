package mapper;

import java.util.List;

import pojo.User;

public interface UserMapper {
	User getUserById(int id);
	List<User> getUserByName(String username);
}
