package com.bowling.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bowling.domain.user.UserVO;
import com.bowling.mapper.user.UserMapper;

@Service("com.bowling.service.UserService")
public class UserService {
	
	@Resource(name="com.bowling.mapper.user.UserMapper")
	UserMapper userMapper;
	
	public UserVO getUserNoByName(UserVO userVO) throws Exception {
		return userMapper.getUser(userVO);
	}
}
