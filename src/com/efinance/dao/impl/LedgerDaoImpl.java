package com.efinance.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.efinance.dao.LedgerDao;
import com.efinance.model.Ledger;
import com.efinance.util.DBUtilDao;

@Component("ledgerDao")
public class LedgerDaoImpl extends BaseDao implements LedgerDao{
	
	
	
	private DBUtilDao utilDao;
	private SessionFactory sessionFactory;

	public void addLedger(Ledger ledger) {
		
		utilDao.save(ledger);
	}

	public void deleteLedger(Ledger ledger) {
		utilDao.delete(ledger);
		
	}

	public Ledger findLedgerById(Integer id) {
		
		return (Ledger) sessionFactory.getCurrentSession().createQuery("from Ledger l where l.l_id=?")
		        .setParameter(0, id).uniqueResult();
	}

	public void updateLedger(Ledger ledger) {
		utilDao.update(ledger);
		
	}

	

	
	
	/*---------------------GET/SET·½·¨--------------------------------------------*/
	public DBUtilDao getDBUtilDao() {
		return utilDao;
	}
@Resource(name="utilDao")
	public void setDBUtilDao(DBUtilDao utilDao) {
		this.utilDao = utilDao;
	}

	
}
