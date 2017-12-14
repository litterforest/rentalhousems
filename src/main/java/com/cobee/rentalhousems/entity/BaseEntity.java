package com.cobee.rentalhousems.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5393040500207890273L;

	private Integer id;
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;
	private String remarks;
	// 0未审核 100审核成功
	private Integer status;

	public BaseEntity() {
		super();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatusDesc()
	{
		if (getStatus() == null)
		{
			return "";
		}
		else if (getStatus() == 0)
		{
			return "未审核";
		}
		else if (getStatus() == 100)
		{
			return "审核通过";
		}
		else
		{
			return "";
		}
	}
	
}
