package com.bowling.mapper.shop;

import org.springframework.stereotype.Repository;

import com.bowling.domain.shop.ShopVO;

@Repository("com.bowling.mapper.shop.ShopMapper")
public interface ShopMapper {
	public ShopVO getShop(ShopVO shopVO);
}
