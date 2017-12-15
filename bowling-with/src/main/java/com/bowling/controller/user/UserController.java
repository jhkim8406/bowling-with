package com.bowling.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bowling.domain.user.UserVO;
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
	
	@RequestMapping(value="/ajax/signUpProc", method=RequestMethod.POST)
	@ResponseBody
	private String SignUpProcByAjax(Model model, HttpServletRequest request) throws Exception {
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String userGender = request.getParameter("user_gender");
		
		String _password = new BCryptPasswordEncoder().encode(password);
		
		UserVO userVO = new UserVO();
		
		userVO.setUserId(userId);
		userVO.setUserName(userName);
		userVO.setUserPassword(_password);
		userVO.setUserGender(userGender);
		userVO.setUserNickname(userName);
		userVO.setUserNickimage("");
		userVO.setUserRole("MEMBER");
		
		String result = Integer.toString(userService.insertUser(userVO));
		
		return result;
	}
	
	@RequestMapping("/update/password")
	private void userPasswordUpdate(Model model) throws Exception {
		userService.UserPasswordUpdate();		
	}
}
