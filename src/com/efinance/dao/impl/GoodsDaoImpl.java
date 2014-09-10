package com.efinance.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.efinance.dao.GoodsDao;
import com.efinance.model.Goods;
import com.efinance.util.DBUtilDao;

@Component("goodsDao")
public class GoodsDaoImpl extends BaseDao implements GoodsDao{
	private DBUtilDao utilDao;
	private SessionFactory sessionFactory;
	
	public DBUtilDao getUtilDao() {
		return utilDao;
	}

	@Resource(name="utilDao")
	public void setUtilDao(DBUtilDao utilDao) {
		this.utilDao = utilDao;
	}
	

	public void deleteGoods(Goods goods) {
		utilDao.delete(goods);
		
	}

	public void addGood(Goods goods) {
		utilDao.save(goods);
		
	}

	public Goods findGoodsById(Integer id) {
		
		return (Goods)sessionFactory.getCurrentSession().createQuery("from Goods u where u.p_id = ?")
		.setParameter(0, id)
		.uniqueResult();
	}

	public void updateGoods(Goods goods) {
		utilDao.update(goods);
		
	}

}
