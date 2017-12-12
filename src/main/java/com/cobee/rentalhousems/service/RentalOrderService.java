package com.cobee.rentalhousems.service;

import com.cobee.rentalhousems.entity.RentalOrder;

public interface RentalOrderService extends BaseService<RentalOrder> {

	void createRentalOrder(RentalOrder rentalOrder);
	
	void audit(Integer id);
	
}
