package com.bowling.mapper.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bowling.domain.user.UserVO;

@Repository("com.bowling.mapper.user.UserMapper")
public interface UserMapper {
	public UserVO getUser(UserVO userVO); 
	
	public List<UserVO> getUserAllList();
	
	public void updateUserPassword(UserVO userVO);
}
