package com.cobee.rentalhousems.service;

import com.cobee.rentalhousems.entity.SecureUser;

public interface SecureUserService extends BaseService<SecureUser> {

	void register(SecureUser baseUser);
	
}
