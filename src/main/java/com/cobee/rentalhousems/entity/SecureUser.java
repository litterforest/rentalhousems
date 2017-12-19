package com.cobee.rentalhousems.entity;

public class SecureUser extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143353763610343789L;
	private String username;
	private String password;
	private String mobile;
	private String realname;
	private Integer isRememberMe;

	private SysVariables sysVariables;

	public SecureUser() {
		super();
	}

	public Integer getIsRememberMe() {
		return isRememberMe;
	}

	public void setIsRememberMe(Integer isRememberMe) {
		this.isRememberMe = isRememberMe;
	}

	public SysVariables getSysVariables() {
		return sysVariables;
	}

	public void setSysVariables(SysVariables sysVariables) {
		this.sysVariables = sysVariables;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}