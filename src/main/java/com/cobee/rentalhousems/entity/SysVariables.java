package com.cobee.rentalhousems.entity;

import java.io.Serializable;
import java.util.Date;

public class SysVariables extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8507953507283481L;

	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;
	private String remarks;
	// 租房当前电费度数
	private Double currentRentingPowerConsumption;
	// 铺位当前电费度数
	private Double currentBerthPowerConsumption;
	// 房租每度电的收费标准
	private Double standardRentingElectricity;
	// 铺位每度电的收费标准
	private Double standardBerthElectricity;

	public SysVariables() {
		super();
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

	public Double getCurrentRentingPowerConsumption() {
		return currentRentingPowerConsumption;
	}

	public void setCurrentRentingPowerConsumption(Double currentRentingPowerConsumption) {
		this.currentRentingPowerConsumption = currentRentingPowerConsumption;
	}

	public Double getCurrentBerthPowerConsumption() {
		return currentBerthPowerConsumption;
	}

	public void setCurrentBerthPowerConsumption(Double currentBerthPowerConsumption) {
		this.currentBerthPowerConsumption = currentBerthPowerConsumption;
	}

	public Double getStandardRentingElectricity() {
		return standardRentingElectricity;
	}

	public void setStandardRentingElectricity(Double standardRentingElectricity) {
		this.standardRentingElectricity = standardRentingElectricity;
	}

	public Double getStandardBerthElectricity() {
		return standardBerthElectricity;
	}

	public void setStandardBerthElectricity(Double standardBerthElectricity) {
		this.standardBerthElectricity = standardBerthElectricity;
	}

}
