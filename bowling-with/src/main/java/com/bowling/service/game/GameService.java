package com.bowling.service.game;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bowling.domain.game.GameVO;
import com.bowling.mapper.game.GameMapper;

@Service("com.bowling.service.GameService")
public class GameService {

	@Resource(name="com.bowling.mapper.game.GameMapper")
	GameMapper gameMapper;
	
	public void insertScoreByExcel(GameVO userVO) throws Exception {
		gameMapper.insertScoreByExcel(userVO);
	}
	
	public GameVO getGameInfoByMain(GameVO userVO) throws Exception {
		return gameMapper.getGameInfoByMain(userVO);
	}
}
