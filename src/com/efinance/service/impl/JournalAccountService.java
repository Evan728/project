package com.efinance.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.efinance.dao.JournalAccountDao;
import com.efinance.model.JournalAccount;
import com.efinance.model.User;

import antlr.collections.List;

@Component("journalAccountService")
@Transactional
public class JournalAccountService {
	
	private JournalAccountDao journalAccountDao;
	
	public void addJournalAccount(JournalAccount journalAccount){
		journalAccountDao.addJournalAccount(journalAccount);							   
	}
	public void updateJournalAccount(JournalAccount journalAccount){
		journalAccountDao.updateJournalAccount(journalAccount);                     
	}
	public void deleteJournalAccount(JournalAccount journalAccount){
		journalAccountDao.deleteJournalAccount(journalAccount);                 
	}
	public JournalAccount findJournalAccountById(Integer id){
		return journalAccountDao.findJournalAccountById(id);
	}
	public JournalAccountDao getJournalAccountDao() {
		return journalAccountDao;
	}
	
	public ArrayList ListJournalAccount(User user){
		return journalAccountDao.ListJournalAccount(user);
		
	}
	@Resource
	public void setJournalAccountDao(JournalAccountDao journalAccountDao) {
		this.journalAccountDao = journalAccountDao;
	}

}
