package com.bowling.controller.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bowling.domain.game.GameVO;
import com.bowling.domain.shop.ShopVO;
import com.bowling.domain.user.UserVO;
import com.bowling.mapper.game.GameMapper;
import com.bowling.mapper.shop.ShopMapper;
import com.bowling.mapper.user.UserMapper;

@Controller
public class CommonController {
	private static final Logger LOG = LoggerFactory.getLogger(CommonController.class);
	
	@Resource(name="com.bowling.mapper.game.GameMapper")
	GameMapper gameMapper;
	
	@Resource(name="com.bowling.mapper.user.UserMapper")
	UserMapper userMapper;
	
	@Resource(name="com.bowling.mapper.shop.ShopMapper")
	ShopMapper shopMapper;
	
	@RequestMapping("/dataUpload")
	private void insertGameInfoByExcel() throws Exception {
		
		System.out.println("upload");
		
		String fileName = "static/excel/season3.xlsx";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		
		File file = new File(classLoader.getResource(fileName).getFile());
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		ArrayList<String> dateList = new ArrayList<String>();
		ArrayList<String> shopList = new ArrayList<String>();
		ArrayList<String> gameTypeList = new ArrayList<String>();
		ArrayList<ArrayList<String>> scoreList = new ArrayList<ArrayList<String>>();
		
		try {
			fis = new FileInputStream(file.getPath());
			workbook = new XSSFWorkbook(fis);
			
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			
			for(int sheetIndex=0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				curSheet = workbook.getSheetAt(sheetIndex);
				
				for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					
					if(rowIndex > -1) {
						curRow = curSheet.getRow(rowIndex);
						String value;
						ArrayList<String> score = new ArrayList<String>();
						
						for(int cellIndex=0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++) {
							curCell = curRow.getCell(cellIndex);
							if(true) {
								value="";
								
								switch (curCell.getCellType()) {
								case XSSFCell.CELL_TYPE_FORMULA:
									value = curCell.getCellFormula();
									break;
								case XSSFCell.CELL_TYPE_NUMERIC:
									value = curCell.getNumericCellValue()+"";
									break;
								case XSSFCell.CELL_TYPE_STRING:
									value = curCell.getStringCellValue()+"";
									break;
								case XSSFCell.CELL_TYPE_BLANK:
									value = curCell.getBooleanCellValue()+"";
									break;
								case XSSFCell.CELL_TYPE_ERROR:
									value = curCell.getErrorCellValue()+"";
									break;
								default:
									value = new String();
									break;
								}
								
								if(rowIndex == 0) {
									dateList.add(cellIndex,value);
								}
								else if(rowIndex == 1) {
									shopList.add(cellIndex,value);
								}
								else if(rowIndex == 2) {
									gameTypeList.add(cellIndex,value);
								}
								else {
									if("false".equals(value)) {
										value="";
									}
									score.add(cellIndex,value);
								}
							}
						}
						if(rowIndex > 2) {
							scoreList.add(rowIndex-3,score);
						}
					}
				}
			}
			
			GameVO game = new GameVO();
			UserVO user = new UserVO();
			ShopVO shop = new ShopVO();
			
			/*
			for(int i=0; i<scoreList.size(); i++) {
			*/
			for(int i=0; i<scoreList.size(); i++) {
				String name = "";
				int game_twohundred_over = 0;
				int score = 0;
				String game_regist_date = "";
				
				for(int j=0; j<scoreList.get(i).size(); j++) {
					if(j==0) {
						name = scoreList.get(i).get(j);
						user.setUserName(name);
						
						int user_no = 0;
						
						if(userMapper.getUser(user) != null) {
							user_no = userMapper.getUser(user).getUserNo();
						}
						game.setUserNo(user_no);
					}
					else {
						if("".equals(scoreList.get(i).get(j))) {
							score = 0;
						}
						else {
							score = (int)Float.parseFloat(scoreList.get(i).get(j));
						}
						
						if(score > 0) {
							game.setUserName(name);
							game.setClubNo(1);
							shop.setShopName(shopList.get(j));
							game.setShopNo(shopMapper.getShop(shop).getShopNo());
							game.setGameAllCover(0);
							if("".equals(scoreList.get(i).get(j))) {
								score = 0;
							}
							else {
								score = (int)Float.parseFloat(scoreList.get(i).get(j));
							}
							
							if(score > 199) {
								game_twohundred_over = 1;
							}
							else {
								game_twohundred_over = 0;
							}
							
							if("정기".equals(gameTypeList.get(j))) {
								game.setGameType(2);
							}
							else if("교류".equals(gameTypeList.get(j))) {
								game.setGameType(3);
							}
							else if("대회".equals(gameTypeList.get(j))) {
								game.setGameType(4);
							}
							else {
								game.setGameType(1);
							}
							
							game.setGameTwohundredOver(game_twohundred_over);
							game.setGameScore(score);
							
							game_regist_date = dateList.get(j);
							try {
								Date _date = new SimpleDateFormat("yyyy-MM-dd").parse(game_regist_date); 
								int month = (_date.getMonth()+1);
								game.setGameMonth(month);
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							game.setGameRegistDate(game_regist_date);
							
							if(game.getUserNo() > 0) {
								gameMapper.insertScoreByExcel(game);
							}
							
							//userMapper.insertScoreByExcel(user);
						}
					}
				}
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(workbook != null) {
					workbook.close();
				}
				if(fis != null) {
					fis.close();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
