package com.cobee.rentalhousems.entity.logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;

import com.cobee.rentalhousems.component.page.Page;
import com.cobee.rentalhousems.entity.RentalOrder;

public class RentalOrderLogic extends RentalOrder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3904393721186112250L;

	public String getRentalTypeDesc() {
		if (super.getRentalType() == null) {
			return "";
		} else if (super.getRentalType() == 0) {
			return "房租";
		} else if (super.getRentalType() == 1) {
			return "铺租";
		} else {
			return "";
		}
	}

	public static Map<String, Object> toJqGridData(Page<RentalOrder> page) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("page", page.getPageNo());
		dataMap.put("total", page.getTotalPage());
		dataMap.put("records", page.getTotalCount());
		
		List<Map<String, Object>> list = new ArrayList<>();
		if (!CollectionUtils.isEmpty(page.getContent())) {
			
			for (int i = 0; i < page.getContent().size(); i++)
			{
				RentalOrderLogic po = (RentalOrderLogic) page.getContent().get(i);
				Map<String, Object> voMap = new HashMap<>();
				voMap.put("id", po.getId());
				voMap.put("yearAndMonth", po.getYear() + "-" + po.getMonth());
				voMap.put("rentalTypeDesc", po.getRentalTypeDesc());
				voMap.put("rentalAmount", po.getRentalAmount());
				voMap.put("electricityAmount", po.getElectricityAmount());
				voMap.put("deductionAmount", po.getDeductionAmount());
				voMap.put("totalAmount", po.getTotalAmount());
				voMap.put("status", po.getStatus() == null ? 0 : po.getStatus());
				voMap.put("statusDesc", po.getStatusDesc());
				voMap.put("createDate", po.getCreateDate() == null ? "" : new DateTime(po.getCreateDate()).toString("yyyy-MM-dd HH:mm:ss"));
				
				list.add(voMap);
			}
		
		}
		dataMap.put("rows", list);
		return dataMap;
	}

}
