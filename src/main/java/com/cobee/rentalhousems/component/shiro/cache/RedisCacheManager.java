package com.cobee.rentalhousems.component.shiro.cache;

import org.apache.shiro.ShiroException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;

import com.cobee.rentalhousems.component.redis.JedisBean;

public class RedisCacheManager implements CacheManager, Initializable, Destroyable {

	private JedisBean jedisBean;
	private int expiredTime;

	public void setJedisBean(JedisBean jedisBean) {
		this.jedisBean = jedisBean;
	}

	public void setExpiredTime(int expiredTime) {
		this.expiredTime = expiredTime;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() throws ShiroException {
		// TODO Auto-generated method stub

	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {

		System.out.println("cache name:" + name);
		
		return new RedisCache<K, V>(jedisBean, expiredTime, name);
	}

}
