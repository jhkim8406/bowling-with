package com.bowling.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {
	public PasswordEncoder passwordEncoder();
	
	public void UserPasswordUpdate();
}
