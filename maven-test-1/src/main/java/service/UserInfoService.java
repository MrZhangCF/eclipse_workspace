package service;

import java.util.List;

import model.UserInfo;

public interface UserInfoService {
	
	public List<UserInfo> getUserInfos();
	
	public UserInfo getUserInfoByID(int id);
	
	public String getValueByRedisKey(String key);
	
}
