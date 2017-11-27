package com.bowling.domain.shop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class ShopVO {
	
	/*볼링장 */
	private int shopNo;
	
	private String shopName;
	
	private String shopAddress;
	
	private String shopDescription;
	
	private String shopRegistDate;
	
}

