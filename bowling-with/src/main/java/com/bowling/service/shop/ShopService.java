package com.bowling.service.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bowling.domain.shop.ShopVO;
import com.bowling.mapper.shop.ShopMapper;

@Service("com.bowling.service.ShopService")
public class ShopService {

	@Resource(name="com.bowling.mapper.shop.ShopMapper")
	ShopMapper shopMapper;
	
	public ShopVO getShop(ShopVO shopVO) throws Exception {
		return shopMapper.getShop(shopVO);
	}
}
