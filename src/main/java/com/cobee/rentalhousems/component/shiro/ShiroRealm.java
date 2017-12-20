package com.cobee.rentalhousems.component.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cobee.rentalhousems.entity.SecureResources;
import com.cobee.rentalhousems.entity.SecureRole;
import com.cobee.rentalhousems.entity.SecureUser;
import com.cobee.rentalhousems.service.SecureResourcesService;
import com.cobee.rentalhousems.service.SecureRoleService;
import com.cobee.rentalhousems.service.SecureUserService;

public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private SecureUserService baseUserService;
	@Autowired
	private SecureRoleService secureRoleService;
	@Autowired
	private SecureResourcesService secureResourcesService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		
		// 登录失败次数太多，用户被锁定
		// TODO
		
		// 获取数据库用户信息
		SecureUser baseUser = new SecureUser();
		baseUser.setUsername(username);
		List<SecureUser> baseUserList = baseUserService.list(baseUser);
		if (CollectionUtils.isEmpty(baseUserList))
		{
			throw new AuthenticationException("用户名或密码错误");
		}
		
		SecureUser dbBaseUser = baseUserList.get(0);
		ByteSource salt = ByteSource.Util.bytes(dbBaseUser.getUsername());
		
		return new SimpleAuthenticationInfo(dbBaseUser, dbBaseUser.getPassword(), salt, getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		SecureUser user = (SecureUser) pc.getPrimaryPrincipal();
		Set<String> roles = new HashSet<>();
		Set<String> stringPermissions = new HashSet<>();
		// 1，获取用户角色
		SecureRole secureRole = new SecureRole();
		secureRole.setSecureUser(user);
		List<SecureRole> secureRoleList = secureRoleService.findUserRoles(secureRole);
		// 2,获取用户权限
		if (!CollectionUtils.isEmpty(secureRoleList))
		{
			for (SecureRole po : secureRoleList)
			{
				roles.add(po.getEnname());
				SecureResources secureResources = new SecureResources();
				secureResources.setSecureRole(po);
				List<SecureResources> secureResourcesList = secureResourcesService.findRolePermissions(secureResources);
				if (!CollectionUtils.isEmpty(secureResourcesList))
				{
					for (SecureResources posr : secureResourcesList)
					{
						stringPermissions.add(posr.getPermission());
					}
				}
			}
		}
		// 3,获取用户直接权限
		SecureResources secureResources = new SecureResources();
		secureResources.setSecureUser(user);
		List<SecureResources> secureResourcesList = secureResourcesService.findRolePermissions(secureResources);
		if (!CollectionUtils.isEmpty(secureResourcesList))
		{
			for (SecureResources po : secureResourcesList)
			{
				stringPermissions.add(po.getPermission());
			}
		}
		
		simpleAuthorizationInfo.setRoles(roles);
		simpleAuthorizationInfo.setStringPermissions(stringPermissions);
		return simpleAuthorizationInfo;
	}

}
