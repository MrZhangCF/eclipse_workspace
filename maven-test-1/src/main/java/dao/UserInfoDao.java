package dao;

import java.util.List;

import model.UserInfo;

public interface UserInfoDao {
	
	public List<UserInfo> getUserInfos();

	public UserInfo getUserInfoByID(int id);
	
}
