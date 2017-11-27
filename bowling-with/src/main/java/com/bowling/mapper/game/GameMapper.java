package com.bowling.mapper.game;

import org.springframework.stereotype.Repository;

import com.bowling.domain.game.GameVO;

@Repository("com.bowling.mapper.game.GameMapper")
public interface GameMapper {
	
	public Integer insertScoreByExcel(GameVO userVO) throws Exception;
	
	public GameVO getGameInfoByMain(GameVO userVO) throws Exception;
}
