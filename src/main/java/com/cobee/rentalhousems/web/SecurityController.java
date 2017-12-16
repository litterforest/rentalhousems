package com.cobee.rentalhousems.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
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
            	// 登录时，创建一个新的会话。安全加固
                if (currentUser.getSession() != null)
                {
                	currentUser.getSession().stop();
                }
                currentUser.login(token);
            }
            catch (IncorrectCredentialsException e)
            {
            	logger.error("", e);
            	responsePage = "redirect:/login";
            	redirectAttributes.addAttribute("errorMsg", "用户名或密码错误");
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
			redirectAttributes.addAttribute("msg", "注册成功，请登录使用");
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
