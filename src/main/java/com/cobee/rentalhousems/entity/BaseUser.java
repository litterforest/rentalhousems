package com.cobee.rentalhousems.entity;

public class BaseUser extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143353763610343789L;
	private String username;
	private String password;
	private String mobile;

	public BaseUser() {
		super();
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
