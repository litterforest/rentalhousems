package com.cobee.rentalhousems.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cobee.rentalhousems.entity.SecureResources;
import com.cobee.rentalhousems.service.SecureUserService;

@Controller
public class HomeController extends AbstractController {
	
	@Autowired
	private SecureUserService secureUserService;
	
	@GetMapping("/home")
	public String index(Model model)
	{
		// 设置用户对应的菜单
		SecureResources menus = secureUserService.getUserMenus();
		model.addAttribute("menus", menus);
		return "home";
	}
	
}
