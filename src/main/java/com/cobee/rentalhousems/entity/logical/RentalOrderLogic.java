package com.cobee.rentalhousems.entity.logical;

import com.cobee.rentalhousems.entity.RentalOrder;

public class RentalOrderLogic extends RentalOrder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3904393721186112250L;
	
	public String getRentalTypeDesc()
	{
		if (super.getRentalType() == null)
		{
			return "";
		}
		else if (super.getRentalType() == 0)
		{
			return "房租";
		}
		else if (super.getRentalType() == 1)
		{
			return "铺租";
		}
		else
		{
			return "";
		}
	}

}
