package com.bowling.mapper.user;

import org.springframework.stereotype.Repository;

import com.bowling.domain.user.UserVO;

@Repository("com.bowling.mapper.user.UserMapper")
public interface UserMapper {
	public UserVO getUser(String userId); 
}
