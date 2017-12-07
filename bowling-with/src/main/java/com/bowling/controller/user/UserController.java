package com.bowling.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bowling.service.user.UserService;

@Controller
@RequestMapping({"","/user"})
public class UserController {
	
	@Autowired 
	private	UserService userService;
	
	@RequestMapping("/login")
	private String Login(Model model) throws Exception {
		
		String returnUrl = "login/login";
		
		if(!"anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
			returnUrl = "redirect:/main";
		}
		
		return returnUrl;
	}
	
	@RequestMapping("/update/password")
	private void userPasswordUpdate(Model model) throws Exception {
		userService.UserPasswordUpdate();		
	}
}
