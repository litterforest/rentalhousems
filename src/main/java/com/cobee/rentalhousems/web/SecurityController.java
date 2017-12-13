package com.cobee.rentalhousems.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cobee.rentalhousems.entity.BaseUser;

@Controller
public class SecurityController extends AbstractController {
	
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
	
	
	
}
