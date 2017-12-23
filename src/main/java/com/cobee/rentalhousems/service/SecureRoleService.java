package com.cobee.rentalhousems.service;

import java.util.List;

import com.cobee.rentalhousems.entity.SecureRole;
import com.cobee.rentalhousems.service.support.BaseService;

public interface SecureRoleService extends BaseService<SecureRole> {
	
	List<SecureRole> findUserRoles(SecureRole secureRole);
	
}
