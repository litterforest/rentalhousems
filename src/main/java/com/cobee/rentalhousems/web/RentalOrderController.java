package com.cobee.rentalhousems.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cobee.rentalhousems.entity.RentalOrder;
import com.cobee.rentalhousems.service.RentalOrderService;

@Controller
@RequestMapping("/rentalorder")
public class RentalOrderController extends AbstractController {

	@Autowired
	private RentalOrderService rentalOrderService;
	
	@GetMapping("/list")
	public String list(Model model)
	{
		RentalOrder rentalOrderQuery = new RentalOrder();
		rentalOrderQuery.setDelFlag(0);
		List<RentalOrder> rentalOrderList = rentalOrderService.list(rentalOrderQuery);
		model.addAttribute("rentalOrderList", rentalOrderList);
		return "rentalOrderList";
		
	}
	
	@GetMapping("/form")
	public String form()
	{
		return "rentalOrderForm";
		
	}
	
	@PostMapping("/save")
	public String save(RentalOrder rentalOrder)
	{
		rentalOrderService.save(rentalOrder);
		return "redirect:list";
		
	}
	
}
