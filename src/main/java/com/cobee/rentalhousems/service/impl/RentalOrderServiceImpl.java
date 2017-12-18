package com.cobee.rentalhousems.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhousems.dao.RentalOrderDao;
import com.cobee.rentalhousems.entity.BaseUser;
import com.cobee.rentalhousems.entity.RentalOrder;
import com.cobee.rentalhousems.entity.SysVariables;
import com.cobee.rentalhousems.service.AbstractService;
import com.cobee.rentalhousems.service.RentalOrderService;
import com.cobee.rentalhousems.service.SysVariablesService;
import com.cobee.rentalhousems.util.NumericUtils;

@Service
public class RentalOrderServiceImpl extends AbstractService<RentalOrder,RentalOrderDao> implements RentalOrderService {
	
	@Autowired
	private SysVariablesService sysVariablesService;

	@Override
	@Transactional(readOnly = false)
	public void createRentalOrder(RentalOrder rentalOrder) {
		
		BaseUser user = (BaseUser) SecurityUtils.getSubject().getPrincipal();
		SysVariables sysVariables = new SysVariables();
		sysVariables.setUserId(user.getId());
		List<SysVariables> sysVariablesList = sysVariablesService.list(sysVariables);
		SysVariables dbSysVariables = sysVariablesList.get(0);

		if (rentalOrder.getId() == null)
		{
			rentalOrder.setUserId(user.getId());
		}
		Double lastPowerConsumption = rentalOrder.getRentalType() == 0 ? dbSysVariables.getCurrentRentingPowerConsumption() : rentalOrder.getRentalType() == 1 ? dbSysVariables.getCurrentBerthPowerConsumption() : 0.0D;
		rentalOrder.setLastPowerConsumption(lastPowerConsumption);
		Double diffPowerConsumption = rentalOrder.getPowerConsumption() - lastPowerConsumption;
		rentalOrder.setDiffPowerConsumption(diffPowerConsumption);
		Double electricityAmount = 0.0;
		if (NumericUtils.equal(rentalOrder.getRentalType(), 0))
		{
			electricityAmount = diffPowerConsumption * dbSysVariables.getStandardRentingElectricity();
		}
		else if(NumericUtils.equal(rentalOrder.getRentalType(), 1))
		{
			electricityAmount = diffPowerConsumption * dbSysVariables.getStandardBerthElectricity();
		}
		rentalOrder.setElectricityAmount(electricityAmount);
		
		Double totalAmount = rentalOrder.getRentalAmount() + rentalOrder.getElectricityAmount() - rentalOrder.getDeductionAmount();
		rentalOrder.setTotalAmount(totalAmount);
		
		save(rentalOrder);
		
	}

	@Override
	@Transactional(readOnly = false)
	public void audit(Integer id) {
		
		RentalOrder rentalOrder = new RentalOrder();
		rentalOrder.setId(id);
		rentalOrder.setStatus(100);
		this.updateBySelective(rentalOrder);
		
		RentalOrder dbRentalOrder = super.get(id);
		Double powerConsumption = dbRentalOrder.getPowerConsumption();
		
		SysVariables sysVariables = new SysVariables();
		sysVariables.setUserId(dbRentalOrder.getUserId());
		List<SysVariables> sysVariablesList = sysVariablesService.list(sysVariables);
		if (!CollectionUtils.isEmpty(sysVariablesList))
		{
			SysVariables newSysVariables = new SysVariables();
			newSysVariables.setId(sysVariablesList.get(0).getId());
			if (dbRentalOrder.getRentalType() == 0)
			{
				newSysVariables.setCurrentRentingPowerConsumption(powerConsumption);
			}
			else if (dbRentalOrder.getRentalType() == 1)
			{
				newSysVariables.setCurrentBerthPowerConsumption(powerConsumption);
			}
			sysVariablesService.updateBySelective(newSysVariables);
		}
		
	}

	@Override
	public boolean isCreatePermission(RentalOrder rentalOrder) {
		rentalOrder.setStatus(0);
		Integer count = super.queryByCount(rentalOrder);
		return count > 0 ? true : false;
	}
	
}
