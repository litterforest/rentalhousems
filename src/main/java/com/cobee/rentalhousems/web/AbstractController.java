package com.cobee.rentalhousems.web;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.cobee.rentalhousems.component.redis.JedisBean;
import com.cobee.rentalhousems.entity.SecureUser;

public abstract class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected JedisBean jedisBean;
	
	/**
	 * <pre>获取已登录的用户对象</pre>
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2017年12月15日
	 *
	 * @return
	 */
	protected SecureUser getLoginUser()
	{
		 return (SecureUser) SecurityUtils.getSubject().getPrincipal();
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
        
    }
	
}
