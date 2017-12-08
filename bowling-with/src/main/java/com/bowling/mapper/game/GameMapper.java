package com.bowling.mapper.game;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bowling.domain.game.GameVO;
import com.bowling.domain.user.UserVO;

@Repository("com.bowling.mapper.game.GameMapper")
public interface GameMapper {
	
	public GameVO getGameInfoByUser(UserVO userVO);
	
	public List<GameVO> getAvgScoreByUserByShop(UserVO userVO);
	
	public Integer insertScoreByExcel(GameVO userVO);
}
