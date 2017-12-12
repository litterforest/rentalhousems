package com.cobee.rentalhousems.entity;

import java.util.Date;

public class RentalOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3827501685095969463L;

	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;
	private String remarks;
	private String year;
	private String month;
	// 出租费
	private Double rentalAmount;
	// 电费
	private Double electricityAmount;
	// 用电度数
	private Double powerConsumption;
	// 总费用
	private Double totalAmount;
	// 出租类型：0房租 1铺租
	private Integer rentalType;
	// 0未审核 100审核成功
	private Integer status;
	// 上月电费度数
	private Double lastPowerConsumption;
	// 删除标记
	private Integer delFlag;
	// 扣减费用
	private Double deductionAmount;
	// 电费使用度数
	private Double diffPowerConsumption;

	public RentalOrder() {
		super();
	}

	public Double getDiffPowerConsumption() {
		return diffPowerConsumption;
	}

	public void setDiffPowerConsumption(Double diffPowerConsumption) {
		this.diffPowerConsumption = diffPowerConsumption;
	}

	public Double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(Double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Double getLastPowerConsumption() {
		return lastPowerConsumption;
	}

	public void setLastPowerConsumption(Double lastPowerConsumption) {
		this.lastPowerConsumption = lastPowerConsumption;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getRentalAmount() {
		return rentalAmount;
	}

	public void setRentalAmount(Double rentalAmount) {
		this.rentalAmount = rentalAmount;
	}

	public Double getElectricityAmount() {
		return electricityAmount;
	}

	public void setElectricityAmount(Double electricityAmount) {
		this.electricityAmount = electricityAmount;
	}

	public Double getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(Double powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getRentalType() {
		return rentalType;
	}

	public void setRentalType(Integer rentalType) {
		this.rentalType = rentalType;
	}

}
