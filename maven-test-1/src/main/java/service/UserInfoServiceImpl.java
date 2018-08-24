package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.RedisDao;
import dao.UserInfoDao;
import model.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Resource
	UserInfoDao userIndoDao;
	
	@Resource
	RedisDao redisDao;
	
	public List<UserInfo> getUserInfos() {
		
		return userIndoDao.getUserInfos();
	}

	public UserInfo getUserInfoByID(int id) {
		return userIndoDao.getUserInfoByID(id);
	}

	public String getValueByRedisKey(String key) {
		return redisDao.get(key);
	}

}
