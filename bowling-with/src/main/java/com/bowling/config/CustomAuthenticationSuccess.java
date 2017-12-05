package com.bowling.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.bowling.mapper.user.UserMapper;

public class CustomAuthenticationSuccess implements AuthenticationSuccessHandler{
	
	@Autowired UserMapper userMapper;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	  
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
	    Authentication authentication) throws IOException, ServletException {
		
		System.out.println("username : " + request.getParameter("username"));
		
		/*
		HttpSession session = null;
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserVO userInfo = new UserVO();
		
		userInfo = userMapper.getUser(user.getUsername());
		
		session.setAttribute("userId", userInfo.getUserId());
		session.setAttribute("userNo", userInfo.getUserId());
		session.setAttribute("userNickname", userInfo.getUserNickname());
		session.setAttribute("userRole", userInfo.getUserRole());
		*/
	    redirectStrategy.sendRedirect(request, response, "/main");
	}
}