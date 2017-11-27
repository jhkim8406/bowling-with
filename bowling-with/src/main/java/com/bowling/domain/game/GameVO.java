package com.bowling.domain.game;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class GameVO {
	/* 회원 */
	private int userNo;
	
	private String userId;
	
	private String userName;
	
	private String userGender;
	
	private String userNickname;
	
	private String userNickimage;
	
	private String userRegistDate;
	
	/* 클럽 */
	private int clubNo;
	
	private String clubName;
	
	/* 매장 */
	private int	shopNo;
	
	private String shopName;
	
	/* 게임 */
	private int gameType;
	
	private int gameMonth;
	
	private int gameScore;
	
	private int gameAllCover;
	
	private int gameTwohundredOver;
	
	private float gameAvg;
	
	private int gamePerfect;
	
	private int gameHigh;
	
	private int gameCount;
	
	private String gameRegistDate;

}
