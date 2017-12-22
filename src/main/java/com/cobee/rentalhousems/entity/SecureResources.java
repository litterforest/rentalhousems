package com.cobee.rentalhousems.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.util.CollectionUtils;

import com.cobee.rentalhousems.util.NumericUtils;

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
	private List<SecureResources> menuList;

	public SecureResources() {
		super();
	}

	public List<SecureResources> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SecureResources> menuList) {
		this.menuList = menuList;
	}
	
	public void addMenu(SecureResources secureResources)
	{
		if (secureResources != null)
		{
			if (menuList == null)
			{
				menuList = new ArrayList<SecureResources>();
			}
			menuList.add(secureResources);
		}
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
	
	public String getWebContent()
	{
		StringBuilder sbuff = new StringBuilder();
		buildWebContent(sbuff);
		return sbuff.toString();
	}
	
	private void buildWebContent(StringBuilder sbuff)
	{
		if (!NumericUtils.equal(super.getId(), 0))
		{
			sbuff.append("<a href=\"/rentalhousems"+ this.srcurl +"\" >"+ this.name +"</a><br/>");
		}
		if (!CollectionUtils.isEmpty(menuList))
		{
			for (SecureResources po : menuList)
			{
				po.buildWebContent(sbuff);
			}
		}
	}

}
