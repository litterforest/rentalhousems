package com.cobee.rentalhousems.dao;

import java.util.List;

import com.cobee.rentalhousems.entity.SecureResources;

public interface SecureResourcesDao extends BaseDao<SecureResources> {
	
	List<SecureResources> findRolePermissions(SecureResources secureResources);
	
	List<SecureResources> findUserPermissions(SecureResources secureResources);
	
	List<SecureResources> findMenusByUserId(Integer userID);
	
}
