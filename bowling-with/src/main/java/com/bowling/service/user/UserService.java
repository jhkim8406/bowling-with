package com.bowling.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bowling.domain.user.UserVO;

public interface UserService extends UserDetailsService {
	
	public Integer insertUser(UserVO userVO);
	
	public PasswordEncoder passwordEncoder();
	
	public void UserPasswordUpdate();
	
}
