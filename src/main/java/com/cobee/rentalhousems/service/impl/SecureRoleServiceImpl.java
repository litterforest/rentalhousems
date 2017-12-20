package com.cobee.rentalhousems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cobee.rentalhousems.dao.SecureRoleDao;
import com.cobee.rentalhousems.entity.SecureRole;
import com.cobee.rentalhousems.service.AbstractService;
import com.cobee.rentalhousems.service.SecureRoleService;

@Service
public class SecureRoleServiceImpl extends AbstractService<SecureRole, SecureRoleDao> implements SecureRoleService {

	@Override
	public List<SecureRole> findUserRoles(SecureRole secureRole) {
		return super.dao.findUserRoles(secureRole);
	}

}
