package com.bowling.domain.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class UserVO {
	
	/* 회원 */
	private int userNo;
	
	private String userId;
	
	private String userPassword;
	
	private String userName;
	
	private String userRole;
	
	private Integer roleNo;
	
	private String userGender;
	
	private String userNickname;
	
	private String userNickimage;
	
	private String userRegistdate;
}

