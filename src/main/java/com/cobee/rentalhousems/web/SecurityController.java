package com.cobee.rentalhousems.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cobee.rentalhousems.entity.BaseUser;
import com.cobee.rentalhousems.service.BaseUserService;

@Controller
public class SecurityController extends AbstractController {
	
	@Autowired
	private BaseUserService baseUserService;
	
	@GetMapping(value="/login")
	public String login()
	{
		return "login";
	}
	
	@PostMapping(value="/doLogin")
	public String doLogin(BaseUser baseUser, RedirectAttributes redirectAttributes)
	{
		Subject currentUser = SecurityUtils.getSubject();
		String responsePage = "redirect:/home";
		if (!currentUser.isAuthenticated()) {
			
            UsernamePasswordToken token = new UsernamePasswordToken(baseUser.getUsername(), baseUser.getPassword());
            
            try
            {
                currentUser.login(token);
            }
            catch (Exception e)
            {
            	logger.error("", e);
            	responsePage = "redirect:/login";
            	redirectAttributes.addAttribute("errorMsg", e.getMessage());
            }
            
        }
		return responsePage;
	}
	
	@GetMapping(value="/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping(value="/doRegister")
	public String doRegister(BaseUser baseUser, RedirectAttributes redirectAttributes)
	{
		
		String resultPage = "redirect:/login";
		try
		{
			baseUserService.register(baseUser);
		}
		catch(Exception e)
		{
			logger.error("", e);
			redirectAttributes.addAttribute("errorMsg", e.getMessage());
			resultPage = "redirect:/register";
		}
		
		return resultPage;
	}
	
}
