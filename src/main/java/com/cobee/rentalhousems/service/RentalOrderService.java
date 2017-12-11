package com.cobee.rentalhousems.service;

import java.util.List;

import com.cobee.rentalhousems.entity.RentalOrder;

public interface RentalOrderService {

	List<RentalOrder> list(RentalOrder rentalOrder);
	
	void save(RentalOrder rentalOrder);
	
}
