package com.bowling.controller.main;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bowling.domain.user.UserVO;
import com.bowling.service.game.GameService;

@Controller
public class MainController {
	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/main")
	private String Main(Model model, HttpServletRequest request) throws Exception {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserVO userVO = new UserVO();
		
		userVO.setUserId(user.getUsername());
		
		model.addAttribute("gameInfoByUser",gameService.getGameInfoByUser(userVO));
		model.addAttribute("avgScoreByUserByShop", gameService.getAvgScoreByUserByShop(userVO));
		
		return "main/main";
	}
}
