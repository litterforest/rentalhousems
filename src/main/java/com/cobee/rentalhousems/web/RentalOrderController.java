package com.cobee.rentalhousems.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cobee.rentalhousems.component.page.Page;
import com.cobee.rentalhousems.component.page.PageRequest;
import com.cobee.rentalhousems.entity.RentalOrder;
import com.cobee.rentalhousems.service.RentalOrderService;
import com.cobee.rentalhousems.web.support.AbstractController;

@Controller
@RequestMapping("/rentalorder")
public class RentalOrderController extends AbstractController {

	@Autowired
	private RentalOrderService rentalOrderService;
	
	@GetMapping("/list")
	public String list(@ModelAttribute("rentalOrder") RentalOrder rentalOrder, Model model)
	{
		
//		List<RentalOrder> rentalOrderList = rentalOrderService.list(rentalOrder);
		PageRequest pageRequest = new PageRequest();
		rentalOrder.setPageRequest(pageRequest);
		Page<RentalOrder> page = rentalOrderService.findByPage(rentalOrder);
		model.addAttribute("rentalOrderList", page.getContent());
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
	
	/**
	 * <pre>检查是否有创建新收费单的权限</pre>
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2017年12月14日
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/isCreatePermission", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> isCreatePermission(RentalOrder rentalOrder)
	{
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			
			if (rentalOrderService.isCreatePermission(rentalOrder))
			{
				resultMap.put("status", "fail");
				resultMap.put("msg", "有收费单未审核，请先处理");
			}
			else
			{
				resultMap.put("status", "success");
			}
			
		} catch (Exception e) {
			logger.error("", e);
			resultMap.put("status", "fail");
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
	
}
