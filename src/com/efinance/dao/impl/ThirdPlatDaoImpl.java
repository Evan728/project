package com.efinance.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.efinance.dao.ThirdPlatDao;
import com.efinance.model.ThirdPlat;
import com.efinance.util.DBUtilDao;
@Component("thirdPlatDao")
public class ThirdPlatDaoImpl extends BaseDao implements ThirdPlatDao {
	
	private DBUtilDao utilDao;
	private SessionFactory sessionFactory;
	

	public void addThirdPlat(ThirdPlat thirdPlat) {
		
		utilDao.save(thirdPlat);
		}

	public void deleteThirdPlat(ThirdPlat thirdPlat) {
		utilDao.delete(thirdPlat);
		
	}

	public ThirdPlat findAllThirdPlatById(int id) {
		return (ThirdPlat) sessionFactory.getCurrentSession().createQuery("from ThirdPlat th where th.t_id=?")
		       .setParameter(0, id).uniqueResult();
		
	}

	public void updatThirdPlat(ThirdPlat thirdPlat) {
		utilDao.update(thirdPlat);
		
	}

	public DBUtilDao getDBUtilDao() {
		return utilDao;
	}
@Resource(name="utilDao")
	public void setDBUtilDao(DBUtilDao utilDao) {
		this.utilDao = utilDao;
	}

}
