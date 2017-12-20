package com.cobee.rentalhousems.entity;

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

	public SecureResources() {
		super();
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
