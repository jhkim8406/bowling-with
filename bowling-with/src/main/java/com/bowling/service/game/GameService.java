package com.bowling.service.game;

import java.util.List;

import com.bowling.domain.game.GameVO;
import com.bowling.domain.user.UserVO;

public interface GameService {

	GameVO getGameInfoByUser(UserVO userVO);
	
	List<GameVO> getAvgScoreByUserByShop(UserVO userVO);
	
	void insertScoreByExcel(GameVO userVO);
}
