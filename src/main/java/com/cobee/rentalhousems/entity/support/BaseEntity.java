package com.cobee.rentalhousems.entity.support;

import java.io.Serializable;
import java.util.Date;

import com.cobee.rentalhousems.component.page.PageRequest;

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
	// 额外条件
	private String additionalCriteria;

	private PageRequest pageRequest; // 分页请求对象，当前页和每页数据大小;数据由浏览器传递过来

	public BaseEntity() {
		super();
	}

	public String getAdditionalCriteria() {
		return additionalCriteria;
	}

	public void setAdditionalCriteria(String additionalCriteria) {
		this.additionalCriteria = additionalCriteria;
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

	public PageRequest getPageRequest() {
		return pageRequest;
	}

	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}

	public String getStatusDesc() {
		if (getStatus() == null) {
			return "";
		} else if (getStatus() == 0) {
			return "未审核";
		} else if (getStatus() == 100) {
			return "审核通过";
		} else {
			return "";
		}
	}

}
