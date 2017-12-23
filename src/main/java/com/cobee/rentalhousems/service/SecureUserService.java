package com.cobee.rentalhousems.service;

import com.cobee.rentalhousems.entity.SecureResources;
import com.cobee.rentalhousems.entity.SecureUser;
import com.cobee.rentalhousems.service.support.BaseService;

public interface SecureUserService extends BaseService<SecureUser> {

	void register(SecureUser baseUser);
	
	/**
	 * <pre>获取登录用户菜单</pre>
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2017年12月22日
	 *
	 * @return
	 */
	SecureResources getUserMenus();
	
}
