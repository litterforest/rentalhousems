package com.cobee.rentalhousems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cobee.rentalhousems.dao.SecureResourcesDao;
import com.cobee.rentalhousems.entity.SecureResources;
import com.cobee.rentalhousems.service.AbstractService;
import com.cobee.rentalhousems.service.SecureResourcesService;

@Service
public class SecureResourcesServiceImpl extends AbstractService<SecureResources, SecureResourcesDao> implements SecureResourcesService {

	@Override
	public List<SecureResources> findRolePermissions(SecureResources secureResources) {
		return dao.findRolePermissions(secureResources);
	}

	@Override
	public List<SecureResources> findUserPermissions(SecureResources secureResources) {
		return dao.findUserPermissions(secureResources);
	}

	@Override
	public List<SecureResources> findMenusByUserId(Integer userID) {
		return dao.findMenusByUserId(userID);
	}

}
