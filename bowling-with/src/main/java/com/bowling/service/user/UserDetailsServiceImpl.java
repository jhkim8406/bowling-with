package com.bowling.service.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bowling.domain.user.UserVO;
import com.bowling.mapper.user.UserMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		UserVO _user = new UserVO();
		
		_user.setUserId(userId);
		
		UserVO user = userMapper.getUser(_user);
		
		System.out.println("userId : " + user.getUserId());
		System.out.println("userPassword : " + user.getUserPassword());
		System.out.println("userName : " + user.getUserName());
		System.out.println("userRole : " + user.getUserRole());
		
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        
        return new User(user.getUserId(), user.getUserPassword(), grantedAuthorities);
	}
}
