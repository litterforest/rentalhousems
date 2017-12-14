package com.cobee.rentalhousems.entity;

public class BaseUser extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143353763610343789L;
	private String username;
	private String password;
	private String mobile;
	private String realname;

	private SysVariables sysVariables;

	public BaseUser() {
		super();
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
