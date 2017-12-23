package com.cobee.rentalhousems.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhousems.component.page.PageRequest;
import com.cobee.rentalhousems.dao.SecureUserDao;
import com.cobee.rentalhousems.entity.SecureResources;
import com.cobee.rentalhousems.entity.SecureUser;
import com.cobee.rentalhousems.entity.SysVariables;
import com.cobee.rentalhousems.entity.logical.SecureResourcesLogic;
import com.cobee.rentalhousems.service.SecureResourcesService;
import com.cobee.rentalhousems.service.SecureUserService;
import com.cobee.rentalhousems.service.SysVariablesService;
import com.cobee.rentalhousems.service.support.AbstractService;
import com.cobee.rentalhousems.util.NumericUtils;

@Service
public class SecureUserServiceImpl extends AbstractService<SecureUser, SecureUserDao> implements SecureUserService {

	@Autowired
	private SysVariablesService sysVariablesService;
	@Autowired
	private SecureResourcesService secureResourcesService;
	
	@Override
	@Transactional(readOnly = false)
	public void register(SecureUser baseUser) {
		
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
	
	@Transactional(readOnly = false)
	@Override
	public void save(SecureUser baseUser) {
		
		String password = baseUser.getPassword();
		if (StringUtils.isNotBlank(password))
		{
			ByteSource salt = ByteSource.Util.bytes(baseUser.getUsername());
			SimpleHash simpleHash = new SimpleHash("MD5", password, salt, 128);
			baseUser.setPassword(simpleHash.toString());
		}
		
		super.save(baseUser);
		
	}

	@Override
	public SecureResources getUserMenus() {
		
		Session session = SecurityUtils.getSubject().getSession();
		Object obj = session.getAttribute("loginuser_menus");
		if (obj != null)
		{
			return (SecureResources) obj;
		}
		else
		{
			SecureUser user = (SecureUser) SecurityUtils.getSubject().getPrincipal();
			List<SecureResources> secureResourcesList;
			// 管理员拥有权限
			if (NumericUtils.equal(user.getIsAdmin(), 1))
			{
				SecureResources secureResources = new SecureResources();
				secureResources.setIsMenu(1);
				PageRequest pageRequest = new PageRequest();
				pageRequest.setOrderByClause(" order by a.sort ");
				secureResourcesList = secureResourcesService.list(secureResources);
			}
			else
			{
				secureResourcesList = secureResourcesService.findMenusByUserId(user.getId());
			}
			if (!CollectionUtils.isEmpty(secureResourcesList))
			{
				SecureResources root = new SecureResourcesLogic();
				root.setId(0);
				SecureResourcesLogic.buildMenuTree(root, secureResourcesList);
				session.setAttribute("loginuser_menus", root);
				return root;
			}
		}
		
		return null;
	}

}
