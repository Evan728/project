package com.efinance.dao;

import com.efinance.model.Goods;


public interface GoodsDao {
	public void addGood(Goods goods);							   
	public void updateGoods(Goods goods);                       
	public void deleteGoods(Goods goods);                      
	public Goods findGoodsById(Integer id);
}
