package dao;

import java.util.List;

import pojo.User;

public interface UserDAO{
	User getUserById(Integer id);
	List<User> getUserByName(String username);
}
