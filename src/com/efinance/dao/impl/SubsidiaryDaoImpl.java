package com.efinance.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.efinance.dao.SubsidiaryDao;
import com.efinance.model.Subsidiary;
import com.efinance.util.DBUtilDao;
@Component("subsidiaryDao")
public class SubsidiaryDaoImpl extends BaseDao implements  SubsidiaryDao{

	
	private DBUtilDao utilDao;
	private SessionFactory sessionFactory;
	
	public void addSubsidiary(Subsidiary subsidiary) {
		utilDao.save(subsidiary);
		
	}

	public void deleteSubsidiary(Subsidiary subsidiary) {
		utilDao.delete(subsidiary);
		
	}

	public Subsidiary findAllSubsidiaryById(Integer id) {
		
		return (Subsidiary) sessionFactory.getCurrentSession().createQuery("from Subsidiary sub where sub.id=?")
		       .setParameter(0, id).uniqueResult();
	}

	public void updatSubsidiary(Subsidiary subsidiary) {
		utilDao.update(subsidiary);
		
	}

	public DBUtilDao getDBUtilDao() {
		return utilDao;
	}
@Resource(name = "utilDao")
	public void setDBUtilDao(DBUtilDao utilDao) {
		this.utilDao = utilDao;
	}




}
