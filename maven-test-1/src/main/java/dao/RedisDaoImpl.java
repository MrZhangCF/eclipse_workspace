package dao;

import utils.JedisUtil;

import javax.annotation.Resource;

import redis.clients.jedis.JedisPool;

public class RedisDaoImpl implements RedisDao{
	
	@Resource
	JedisPool jedisPool;

	public String get(String key) {
		JedisUtil jedisUtil = new JedisUtil(jedisPool);
		JedisUtil.Strings strings = jedisUtil.new Strings();
		System.out.println("cache: " + strings.get(key));
		return strings.get(key);
	}

}
