package com.cobee.rentalhousems.component.shiro.cache;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobee.rentalhousems.component.redis.JedisBean;
import com.cobee.rentalhousems.entity.SecureUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

public class AuthoRedisCache implements Cache<SimplePrincipalCollection, SimpleAuthorizationInfo> {

	private static final Logger logger = LoggerFactory.getLogger(AuthoRedisCache.class);
	
	private JedisBean jedisBean;
	private int expiredTime;
	private String cacheName;
	private ObjectMapper objectMapper;
	
	public AuthoRedisCache(JedisBean jedisBean, int expiredTime, String cacheName) {
		if (jedisBean == null) {
			throw new IllegalArgumentException("JedisBean argument cannot be null.");
		} else {
			this.jedisBean = jedisBean;
		}
		objectMapper = new ObjectMapper();
		this.cacheName = cacheName;
		this.expiredTime = expiredTime;
	}
	
	@Override
	public void clear() throws CacheException {
		// TODO Auto-generated method stub
	}

	@Override
	public SimpleAuthorizationInfo get(SimplePrincipalCollection key) throws CacheException {
		SimpleAuthorizationInfo value = null;
		Jedis jedis = null;
		try
		{
			jedis = jedisBean.getJedis();
			SecureUser secureUser = (SecureUser) key.getPrimaryPrincipal();
			String redisKey = cacheName + ":" + secureUser.getUsername() + secureUser.getId();
			String jsonStr = jedis.get(redisKey);
			if (StringUtils.isNotBlank(jsonStr))
			{
				value = objectMapper.readValue(jsonStr, SimpleAuthorizationInfo.class);
			}
		}
		catch (JsonProcessingException e)
		{
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		finally
		{
			if (jedis != null)
			{
				jedis.close();
			}
		}
			
		return value;
	}

	@Override
	public Set<SimplePrincipalCollection> keys() {
		return null;
	}

	@Override
	public SimpleAuthorizationInfo put(SimplePrincipalCollection key, SimpleAuthorizationInfo value) throws CacheException {
		
		
		Jedis jedis = null;
		try
		{
			jedis = jedisBean.getJedis();
			SecureUser secureUser = (SecureUser) key.getPrimaryPrincipal();
			String jsonStr = objectMapper.writeValueAsString(value);
			if (StringUtils.isNotBlank(jsonStr))
			{
				String redisKey = cacheName + ":" + secureUser.getUsername() + secureUser.getId();
				jedis.set(redisKey, jsonStr);
				jedis.expire(redisKey, expiredTime);
			}
		}
		catch (JsonProcessingException e)
		{
			logger.error("", e);
		}
		finally
		{
			if (jedis != null)
			{
				jedis.close();
			}
		}
		
		return value;
	}

	@Override
	public SimpleAuthorizationInfo remove(SimplePrincipalCollection key) throws CacheException {
		
		SimpleAuthorizationInfo value = null;
		
		Jedis jedis = null;
		try
		{
			// 1,获取已经存在的权限数据
			jedis = jedisBean.getJedis();
			SecureUser secureUser = (SecureUser) key.getPrimaryPrincipal();
			String redisKey = cacheName + ":" + secureUser.getUsername() + secureUser.getId();
			String jsonStr = jedis.get(redisKey);
			if (StringUtils.isNotBlank(jsonStr))
			{
				value = objectMapper.readValue(jsonStr, SimpleAuthorizationInfo.class);
			}
			
			// 2,删除redis中的用户权限数据
			jedis.del(redisKey);
			
		}
		catch (JsonProcessingException e)
		{
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		finally
		{
			if (jedis != null)
			{
				jedis.close();
			}
		}
		return value;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Collection<SimpleAuthorizationInfo> values() {
		return null;
	}

}
