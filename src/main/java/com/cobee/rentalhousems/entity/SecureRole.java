package com.cobee.rentalhousems.entity;

import java.util.Set;

import com.cobee.rentalhousems.entity.support.BaseEntity;

/**
 * <pre>
 * 安全框架 - 角色表
 * </pre>
 * 
 * @author 陈淦森
 * @version 1.0.1
 * @date 2017年12月18日
 *
 */
public class SecureRole extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5022554949555163806L;
	// 角色英文名字
	private String enname;
	// 角色中文名字
	private String name;

	private SecureUser secureUser;
	private Set<SecureResources> resources;

	public SecureUser getSecureUser() {
		return secureUser;
	}

	public void setSecureUser(SecureUser secureUser) {
		this.secureUser = secureUser;
	}

	public Set<SecureResources> getResources() {
		return resources;
	}

	public void setResources(Set<SecureResources> resources) {
		this.resources = resources;
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
