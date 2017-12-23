package com.cobee.rentalhousems.service;

import com.cobee.rentalhousems.entity.RentalOrder;
import com.cobee.rentalhousems.service.support.BaseService;

public interface RentalOrderService extends BaseService<RentalOrder> {

	void createRentalOrder(RentalOrder rentalOrder);
	
	void audit(Integer id);

	boolean isCreatePermission(RentalOrder rentalOrder);
	
}
