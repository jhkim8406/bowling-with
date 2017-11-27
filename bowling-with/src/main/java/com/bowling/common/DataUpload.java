package com.bowling.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bowling.domain.game.GameVO;

public class DataUpload {
	
	public static void main(String[] args) {
		
		String fileName = "excel/data.xlsx";
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> shop = new ArrayList<String>();
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
									date.add(cellIndex,value);
								}
								else if(rowIndex == 1) {
									shop.add(cellIndex,value);
								}
								else {
									if("false".equals(value)) {
										value="";
									}
									score.add(cellIndex,value);
								}
							}
						}
						if(rowIndex > 1) {
							scoreList.add(rowIndex-2,score);
						}
					}
				}
			}
			
			GameVO user = new GameVO();
			
			for(int i=0; i<scoreList.size(); i++) {
				String name = "";
				int game_twohundred_over = 0;
				int score = 0;
				String game_month = "";
				String game_regist_date = "";
				
				for(int j=0; j<scoreList.get(i).size(); j++) {
					if(j==0) {
						name = scoreList.get(i).get(j);
					}
					else {
						user.setUser_name(name);
						user.setClub_no(1);
						user.setShop_name(shop.get(j));
						user.setGame_month(1);
						user.setGame_all_cover(0);
						if("".equals(scoreList.get(i).get(j))) {
							score = 0;
						}
						else {
							score = (int)Float.parseFloat(scoreList.get(i).get(j));
						}
						
						if(score > 199) {
							game_twohundred_over = 1;
						}
						user.setGame_twohundred_over(game_twohundred_over);
						user.setGame_score(score);
						
						game_regist_date = date.get(j);
						try {
							Date _date = new SimpleDateFormat("yyyy-MM-dd").parse(game_regist_date); 
							int month = (_date.getMonth()+1);
							user.setGame_month(month);
						}
						catch(Exception e) {
							e.printStackTrace();
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
