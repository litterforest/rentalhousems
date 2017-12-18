package com.cobee.rentalhousems.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cobee.rentalhousems.entity.BaseUser;
import com.cobee.rentalhousems.service.BaseUserService;

@Controller
@RequestMapping("/BaseUser")
public class BaseUserController extends AbstractController {
	
	@Autowired
	private BaseUserService baseUserService;
	
	@RequestMapping("/form/{id}")
	public String form(@PathVariable Integer id, Model model)
	{
		BaseUser user = baseUserService.get(id);
		model.addAttribute("user", user);
		return "baseUserForm";
	}
	
	@RequestMapping("/save")
	public String form(BaseUser baseUser, RedirectAttributes redirectAttributes)
	{
		try {
			
			baseUserService.save(baseUser);
			redirectAttributes.addAttribute("msg", "用户修改成功");
			
		} catch (Exception e) {
			logger.error("", e);
			redirectAttributes.addAttribute("errorMsg", e.getMessage());
		}
		
		return "redirect:/home";
	}
	
}
