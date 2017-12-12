package com.cobee.rentalhousems.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhousems.dao.RentalOrderDao;
import com.cobee.rentalhousems.dao.SysVariablesDao;
import com.cobee.rentalhousems.entity.RentalOrder;
import com.cobee.rentalhousems.entity.SysVariables;
import com.cobee.rentalhousems.service.AbstractService;
import com.cobee.rentalhousems.service.RentalOrderService;

@Service
@Transactional(readOnly = true)
public class RentalOrderServiceImpl extends AbstractService<RentalOrder,RentalOrderDao> implements RentalOrderService {
	
	@Autowired
	private SysVariablesDao sysVariablesDao;

	@Override
	@Transactional(readOnly = false)
	public void createRentalOrder(RentalOrder rentalOrder) {
		
		List<SysVariables> sysVariablesList = sysVariablesDao.list(new SysVariables());
		SysVariables sysVariables = sysVariablesList.get(0);
		
		rentalOrder.setDelFlag(0);
		rentalOrder.setStatus(0);
		rentalOrder.setCreateDate(new Date());
		rentalOrder.setUpdateDate(new Date());
		
		Double lastPowerConsumption = rentalOrder.getRentalType() == 0 ? sysVariables.getCurrentRentingPowerConsumption() : rentalOrder.getRentalType() == 1 ? sysVariables.getCurrentBerthPowerConsumption() : 0.0D;
		rentalOrder.setLastPowerConsumption(lastPowerConsumption);
		Double diffPowerConsumption = rentalOrder.getPowerConsumption() - lastPowerConsumption;
		rentalOrder.setDiffPowerConsumption(diffPowerConsumption);
		Double electricityAmount = 0.0;
		if (rentalOrder.getRentalType() == 0)
		{
			electricityAmount = diffPowerConsumption * sysVariables.getStandardRentingElectricity();
		}
		else if(rentalOrder.getRentalType() == 1)
		{
			electricityAmount = diffPowerConsumption * sysVariables.getStandardBerthElectricity();
		}
		rentalOrder.setElectricityAmount(electricityAmount);
		
		Double totalAmount = rentalOrder.getRentalAmount() + rentalOrder.getElectricityAmount() - rentalOrder.getDeductionAmount();
		rentalOrder.setTotalAmount(totalAmount);
		
		save(rentalOrder);
		
	}
	
}
