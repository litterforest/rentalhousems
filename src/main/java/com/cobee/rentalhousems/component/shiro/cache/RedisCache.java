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

public class RedisCache<K, V> implements Cache<K, V> {

	private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);
	
	private static final String AUTHORIZATIONCACHENAME = "redisAuthorizationCache";
	
	private JedisBean jedisBean;
	private int expiredTime;
	private String cacheName;
	private ObjectMapper objectMapper;
	
	public RedisCache(JedisBean jedisBean, int expiredTime, String cacheName) {
		if (jedisBean == null) {
			throw new IllegalArgumentException("JedisBean argument cannot be null.");
		} else {
			this.jedisBean = jedisBean;
		}
		objectMapper = new ObjectMapper();
		this.cacheName = cacheName;
	}
	
	@Override
	public void clear() throws CacheException {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) throws CacheException {
		V value = null;
		if (StringUtils.equals(AUTHORIZATIONCACHENAME, cacheName))
		{
			Jedis jedis = null;
			try
			{
				jedis = jedisBean.getJedis();
				SimplePrincipalCollection spc = (SimplePrincipalCollection) key;
				SecureUser secureUser = (SecureUser) spc.getPrimaryPrincipal();
				String jsonStr = jedis.hget(cacheName, secureUser.getUsername() + secureUser.getId());
				if (StringUtils.isNotBlank(jsonStr))
				{
					value = (V) objectMapper.readValue(jsonStr, SimpleAuthorizationInfo.class);
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
			
		}
		return value;
	}

	@Override
	public Set<K> keys() {
		return null;
	}

	@Override
	public V put(K key, V value) throws CacheException {
		
		if (StringUtils.equals(AUTHORIZATIONCACHENAME, cacheName))
		{
			Jedis jedis = null;
			try
			{
				jedis = jedisBean.getJedis();
				SimplePrincipalCollection spc = (SimplePrincipalCollection) key;
				SecureUser secureUser = (SecureUser) spc.getPrimaryPrincipal();
				String jsonStr = objectMapper.writeValueAsString(value);
				if (StringUtils.isNotBlank(jsonStr))
				{
					jedis.hset(cacheName, secureUser.getUsername() + secureUser.getId(), jsonStr);
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
		}
		
		return value;
	}

	@Override
	public V remove(K key) throws CacheException {
		V value = null;
		if (StringUtils.equals(AUTHORIZATIONCACHENAME, cacheName))
		{
			Jedis jedis = null;
			try
			{
				// 1,获取已经存在的权限数据
				jedis = jedisBean.getJedis();
				SimplePrincipalCollection spc = (SimplePrincipalCollection) key;
				SecureUser secureUser = (SecureUser) spc.getPrimaryPrincipal();
				String jsonStr = jedis.hget(cacheName, secureUser.getUsername() + secureUser.getId());
				if (StringUtils.isNotBlank(jsonStr))
				{
					value = (V) objectMapper.readValue(jsonStr, SimpleAuthorizationInfo.class);
				}
				
				// 2,删除redis中的用户权限数据
				jedis.hdel(cacheName, secureUser.getUsername() + secureUser.getId());
				
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
		}
		return value;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Collection<V> values() {
		return null;
	}

}
