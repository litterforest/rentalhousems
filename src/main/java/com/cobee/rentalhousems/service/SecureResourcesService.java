package com.cobee.rentalhousems.service;

import java.util.List;

import com.cobee.rentalhousems.entity.SecureResources;

public interface SecureResourcesService extends BaseService<SecureResources> {
	
	List<SecureResources> findRolePermissions(SecureResources secureResources);
	
	List<SecureResources> findUserPermissions(SecureResources secureResources);
	
}
