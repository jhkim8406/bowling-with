package com.bowling.controller.main;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bowling.domain.game.GameVO;
import com.bowling.mapper.game.GameMapper;

@Controller
public class MainController {
	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
	@Resource(name="com.bowling.mapper.game.GameMapper")
	GameMapper gameMapper;
	
	@RequestMapping("/main")
	private String Main(Model model, HttpServletRequest request) throws Exception {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		GameVO gameVO = new GameVO();
		
		gameVO.setUser_id(user.getUsername());
		
		model.addAttribute("mainInfo",gameMapper.getGameInfoByMain(gameVO));
		
		return "main/main";
	}
}
