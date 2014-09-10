package com.efinance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.efinance.dao.GoodsDao;
import com.efinance.model.Goods;

@Component("goodsService")
@Transactional
public class GoodsService {

	private GoodsDao goodsDao;
	
	public void deleteGoods(Goods goods) {
		goodsDao.deleteGoods(goods);
		
	}

	public void addGood(Goods goods) {
		goodsDao.addGood(goods);
		
	}

	public Goods findGoodsById(Integer id) {
		
		return goodsDao.findGoodsById(id);
	}

	public void updateGoods(Goods goods) {
		goodsDao.updateGoods(goods);
		
	}
	
	

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}
@Resource
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
}
