package com.efinance.dao.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.efinance.dao.TransactionDao;
import com.efinance.model.JournalAccount;
import com.efinance.model.TransactionInfo;
import com.efinance.model.User;
import com.efinance.util.DBUtilDao;


@Component("transactionDao")
public class TransactionDaoImpl extends BaseDao implements TransactionDao {
	
	
	private DBUtilDao utilDao;
	private SessionFactory sessionFactory;
	
	public void addTransactionInfo(TransactionInfo transactionInfo){
		utilDao.save(transactionInfo);							   
	}
	public void updateTransactionInfo(TransactionInfo transactionInfo){
		utilDao.update(transactionInfo);                       
	}
	public void deleteTransactionInfo(TransactionInfo transactionInfo){
		utilDao.delete(transactionInfo);                      
	}
	public TransactionInfo findTransactionInfoById(Integer id){
		return (TransactionInfo) sessionFactory.getCurrentSession().createQuery("from TransactionInfo jo where jo.TransactionID=? ")
		       .setParameter(0, id).uniqueResult();
	}
	
	public ArrayList ListTransactionInfo(User user){
		
		 String sql="from JournalAccount jo where jo.buyer=?";
		 ArrayList a = (ArrayList) this.sessionFactory.getCurrentSession().createQuery(sql).setParameter(0, user).list();
		
		 return a;
	}
	
	public DBUtilDao getdBUtilDao() {
		return utilDao;
	}
	@Resource(name="utilDao")
	public void setdBUtilDao(DBUtilDao utilDao) {
		this.utilDao = utilDao;
	}
}
