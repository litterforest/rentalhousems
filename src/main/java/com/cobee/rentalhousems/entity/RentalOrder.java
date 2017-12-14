package com.cobee.rentalhousems.entity;

public class RentalOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3827501685095969463L;

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
	// 上月电费度数
	private Double lastPowerConsumption;
	// 删除标记
	private Integer delFlag;
	// 扣减费用
	private Double deductionAmount;
	// 电费使用度数
	private Double diffPowerConsumption;
	// 用户外键ID
	private Integer userId;

	public RentalOrder() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
