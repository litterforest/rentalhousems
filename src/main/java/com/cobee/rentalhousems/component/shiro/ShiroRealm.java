package com.cobee.rentalhousems.component.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cobee.rentalhousems.entity.BaseUser;
import com.cobee.rentalhousems.service.BaseUserService;

public class ShiroRealm extends AuthenticatingRealm {

	@Autowired
	private BaseUserService baseUserService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		
		// 登录失败次数太多，用户被锁定
		// TODO
		
		// 获取数据库用户信息
		BaseUser baseUser = new BaseUser();
		baseUser.setUsername(username);
		List<BaseUser> baseUserList = baseUserService.list(baseUser);
		if (CollectionUtils.isEmpty(baseUserList))
		{
			throw new AuthenticationException("用户名或密码错误");
		}
		
		BaseUser dbBaseUser = baseUserList.get(0);
		ByteSource salt = ByteSource.Util.bytes(dbBaseUser.getUsername());
		
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(dbBaseUser, dbBaseUser.getPassword(), salt, getName());
		return authenticationInfo;
	}

}
