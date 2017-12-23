package com.cobee.rentalhousems.entity;

import com.cobee.rentalhousems.entity.support.BaseEntity;

public class SecureResources extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8465155335970783707L;

	private Integer parentId;
	private String name;
	private Integer sort;
	private String srcurl;
	private String permission;
	// 是否为菜单，0否 1是
	private Integer isMenu;

	private SecureRole secureRole;
	private SecureUser secureUser;

	public SecureResources() {
		super();
	}

	public Integer getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}

	public SecureUser getSecureUser() {
		return secureUser;
	}

	public void setSecureUser(SecureUser secureUser) {
		this.secureUser = secureUser;
	}

	public SecureRole getSecureRole() {
		return secureRole;
	}

	public void setSecureRole(SecureRole secureRole) {
		this.secureRole = secureRole;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSrcurl() {
		return srcurl;
	}

	public void setSrcurl(String srcurl) {
		this.srcurl = srcurl;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
