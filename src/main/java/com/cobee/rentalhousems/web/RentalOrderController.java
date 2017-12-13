package com.cobee.rentalhousems.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cobee.rentalhousems.entity.RentalOrder;
import com.cobee.rentalhousems.service.RentalOrderService;

@Controller
@RequestMapping("/rentalorder")
public class RentalOrderController extends AbstractController {

	@Autowired
	private RentalOrderService rentalOrderService;
	
	@GetMapping("/list")
	public String list(RentalOrder rentalOrder, Model model)
	{
		List<RentalOrder> rentalOrderList = rentalOrderService.list(rentalOrder);
		model.addAttribute("rentalOrderList", rentalOrderList);
		return "rentalOrderList";
	}
	
	@GetMapping("/form")
	public String form()
	{
		return "rentalOrderForm";
		
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Integer id, @MatrixVariable(required=false, defaultValue="0") Integer q, Model model)
	{
		RentalOrder rentalOrder = rentalOrderService.get(id);
		model.addAttribute("rentalOrder", rentalOrder);
		model.addAttribute("q", q);
		return "rentalOrderDetail";
		
	}
	
	@PostMapping("/save")
	public String save(RentalOrder rentalOrder)
	{
		rentalOrderService.createRentalOrder(rentalOrder);
		return "redirect:list";
	}
	
	@RequestMapping("/audit/{id}")
	public String audit(@PathVariable Integer id)
	{
		
		rentalOrderService.audit(id);
		
		return "redirect:list";
	}
	
}
