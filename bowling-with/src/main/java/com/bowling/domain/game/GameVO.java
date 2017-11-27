package com.bowling.domain.game;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class GameVO {
	/* 회원 */
	private int user_no;
	
	private String user_id;
	
	private String user_name;
	
	private String user_gender;
	
	private String user_nickname;
	
	private String user_nickimage;
	
	private String user_regist_date;
	
	/* 클럽 */
	private int club_no;
	
	private String club_name;
	
	/* 매장 */
	private int	shop_no;
	
	private String shop_name;
	
	/* 게임 */
	private int game_month;
	
	private int game_score;
	
	private int game_all_cover;
	
	private int game_twohundred_over;
	
	private float game_avg;
	
	private int game_perfect;
	
	private int game_high;
	
	private int game_count;
	
	private String game_regist_date;
}
