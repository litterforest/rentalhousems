package com.cobee.rentalhousems.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cobee.rentalhousems.entity.SecureUser;
import com.cobee.rentalhousems.service.SecureUserService;

@Controller
@RequestMapping("/SecureUser")
public class SecureUserController extends AbstractController {
	
	@Autowired
	private SecureUserService baseUserService;
	
	@RequestMapping("/form/{id}")
	public String form(@PathVariable Integer id, Model model)
	{
		SecureUser user = baseUserService.get(id);
		model.addAttribute("user", user);
		return "secureUserForm";
	}
	
	@RequestMapping("/save")
	public String form(SecureUser baseUser, RedirectAttributes redirectAttributes)
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
