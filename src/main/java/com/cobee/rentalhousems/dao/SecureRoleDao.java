package com.cobee.rentalhousems.dao;

import java.util.List;

import com.cobee.rentalhousems.dao.support.BaseDao;
import com.cobee.rentalhousems.entity.SecureRole;

public interface SecureRoleDao extends BaseDao<SecureRole> {

	List<SecureRole> findUserRoles(SecureRole secureRole);
	
}
