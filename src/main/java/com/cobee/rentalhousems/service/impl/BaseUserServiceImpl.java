package com.cobee.rentalhousems.service.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhousems.dao.BaseUserDao;
import com.cobee.rentalhousems.entity.BaseUser;
import com.cobee.rentalhousems.entity.SysVariables;
import com.cobee.rentalhousems.service.AbstractService;
import com.cobee.rentalhousems.service.BaseUserService;
import com.cobee.rentalhousems.service.SysVariablesService;

@Service
public class BaseUserServiceImpl extends AbstractService<BaseUser, BaseUserDao> implements BaseUserService {

	@Autowired
	private SysVariablesService sysVariablesService;
	
	@Override
	@Transactional(readOnly = false)
	public void register(BaseUser baseUser) {
		
		String password = baseUser.getPassword();
		ByteSource salt = ByteSource.Util.bytes(baseUser.getUsername());
		SimpleHash simpleHash = new SimpleHash("MD5", password, salt, 128);
		baseUser.setPassword(simpleHash.toString());
		super.save(baseUser);
		
		// 创建sysvariables数据
		SysVariables sysVariables = new SysVariables();
		sysVariables.setUserId(baseUser.getId());
		List<SysVariables> sysVariablesList = sysVariablesService.list(sysVariables);
		if (CollectionUtils.isEmpty(sysVariablesList))
		{
			SysVariables newSysVariables = new SysVariables();
			newSysVariables.setUserId(baseUser.getId());
			newSysVariables.setCurrentBerthPowerConsumption(0.0D);
			newSysVariables.setCurrentRentingPowerConsumption(0.0D);
			newSysVariables.setStandardBerthElectricity(0.0D);
			newSysVariables.setStandardRentingElectricity(0.0D);
			sysVariablesService.save(newSysVariables);
		}
		
	}

}
