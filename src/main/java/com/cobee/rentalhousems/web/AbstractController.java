package com.cobee.rentalhousems.web;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobee.rentalhousems.entity.BaseUser;

public abstract class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * <pre>获取已登录的用户对象</pre>
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2017年12月15日
	 *
	 * @return
	 */
	protected BaseUser getLoginUser()
	{
		 return (BaseUser) SecurityUtils.getSubject().getPrincipal();
	}
	
}
