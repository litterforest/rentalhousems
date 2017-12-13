package com.cobee.rentalhousems.service.impl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhousems.dao.BaseUserDao;
import com.cobee.rentalhousems.entity.BaseUser;
import com.cobee.rentalhousems.service.AbstractService;
import com.cobee.rentalhousems.service.BaseUserService;

@Service
public class BaseUserServiceImpl extends AbstractService<BaseUser, BaseUserDao> implements BaseUserService {

	@Override
	@Transactional(readOnly = false)
	public void register(BaseUser baseUser) {
		
		String password = baseUser.getPassword();
		ByteSource salt = ByteSource.Util.bytes(baseUser.getUsername());
		SimpleHash simpleHash = new SimpleHash("MD5", password, salt, 128);
		baseUser.setPassword(simpleHash.toString());
		super.save(baseUser);
		
	}

}
