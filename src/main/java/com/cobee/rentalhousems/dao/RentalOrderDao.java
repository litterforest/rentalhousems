package com.cobee.rentalhousems.dao;

import java.util.List;

import com.cobee.rentalhousems.entity.RentalOrder;

public interface RentalOrderDao {
	
	List<RentalOrder> list(RentalOrder rentalOrder);
	
	RentalOrder get(Integer id);
	
	void insertBySelective(RentalOrder rentalOrder);
	
	Integer delete(Integer id);
	
	Integer updateBySelective(RentalOrder rentalOrder);
	
}
