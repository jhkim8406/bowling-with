package com.bowling.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@RequestMapping("/signUp")
	private String SignUp(Model model) throws Exception {
		
		return "login/signUp";
	}
	
	@RequestMapping("/ajax/signUp")
	private String SignUpProcByAjax(Model model, HttpServletRequest request) throws Exception {
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		return "/main";
	}
	
	@RequestMapping("/update/password")
	private void userPasswordUpdate(Model model) throws Exception {
		userService.UserPasswordUpdate();		
	}
}
