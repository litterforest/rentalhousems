package com.cobee.rentalhousems.entity;

import java.util.Date;

public class SysVariables extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8507953507283481L;

	// 租房当前电费度数
	private Double currentRentingPowerConsumption;
	// 铺位当前电费度数
	private Double currentBerthPowerConsumption;
	// 房租每度电的收费标准
	private Double standardRentingElectricity;
	// 铺位每度电的收费标准
	private Double standardBerthElectricity;
	// 用户外键ID
	private Integer userId;

	public SysVariables() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
