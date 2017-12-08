package com.bowling.service.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bowling.domain.game.GameVO;
import com.bowling.domain.user.UserVO;
import com.bowling.mapper.game.GameMapper;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired GameMapper gameMapper;
	
	@Override
	public GameVO getGameInfoByUser(UserVO userVO) {
		return gameMapper.getGameInfoByUser(userVO);
	}
	
	@Override
	public List<GameVO> getAvgScoreByUserByShop(UserVO userVO) {
		
		List<GameVO> gameVO = gameMapper.getAvgScoreByUserByShop(userVO);
		
		return gameVO;
	}
	
	@Override
	public void insertScoreByExcel(GameVO userVO) {
		gameMapper.insertScoreByExcel(userVO);
	}
}
