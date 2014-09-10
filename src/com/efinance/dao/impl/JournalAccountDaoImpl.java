package com.efinance.dao.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.efinance.dao.JournalAccountDao;
import com.efinance.model.JournalAccount;
import com.efinance.model.User;
import com.efinance.util.DBUtilDao;
@Component("journalAccountDao")
public class JournalAccountDaoImpl extends BaseDao implements JournalAccountDao {
	
	
	private DBUtilDao utilDao;
	private SessionFactory sessionFactory;
	
	public void addJournalAccount(JournalAccount journalAccount){
		utilDao.save(journalAccount);							   
	}
	public void updateJournalAccount(JournalAccount journalAccount){
		utilDao.update(journalAccount);                       
	}
	public void deleteJournalAccount(JournalAccount journalAccount){
		utilDao.delete(journalAccount);                      
	}
	public JournalAccount findJournalAccountById(Integer id){
		return (JournalAccount) sessionFactory.getCurrentSession().createQuery("from JournalAccount jo where jo.j_id=? ")
		       .setParameter(0, id).uniqueResult();
	}
	
	public ArrayList ListJournalAccount(User user){
		
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
