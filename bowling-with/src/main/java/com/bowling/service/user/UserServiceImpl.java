package com.bowling.service.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bowling.domain.user.UserVO;
import com.bowling.mapper.user.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired UserMapper userMapper;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		UserVO _userVO = new UserVO();
		
		_userVO.setUserId(userId);
		
		UserVO userVO = userMapper.getUser(_userVO);
		
		grantedAuthorities.add(new SimpleGrantedAuthority(userVO.getUserRole()));
		User user = new User(userVO.getUserId(), userVO.getUserPassword(), grantedAuthorities);
		
        return user;
	}
	
	@Override
	public void UserPasswordUpdate() {
		
		List<UserVO> userList = userMapper.getUserAllList();
		
		if(userList != null) {
			for(int i=0; i<userList.size(); i++) {
				String rawPassword = userList.get(i).getUserPassword();
				String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
				UserVO user = new UserVO();
				user.setUserPassword(encodedPassword);
				user.setUserNo(userList.get(i).getUserNo());
				
				userMapper.updateUserPassword(user);
			}
		}
	}
	
	@Override
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}
}
