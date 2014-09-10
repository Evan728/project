package com.efinance.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.efinance.dao.JournalAccountDao;
import com.efinance.dao.TransactionDao;
import com.efinance.model.JournalAccount;
import com.efinance.model.TransactionInfo;
import com.efinance.model.User;

import antlr.collections.List;

@Component("transactionService")
@Transactional
public class TransactionService {
	
	private TransactionDao transactionDao;
	
	public void addTransactionInfo(TransactionInfo transactionInfo){
		transactionDao.addTransactionInfo(transactionInfo);							   
	}
	public void updateTransactionInfo(TransactionInfo transactionInfo){
		transactionDao.updateTransactionInfo(transactionInfo);                     
	}
	public void deleteTransactionInfo(TransactionInfo transactionInfo){
		transactionDao.deleteTransactionInfo(transactionInfo);                 
	}
	public TransactionDao findTransactionInfoById(Integer id){
		return (TransactionDao) transactionDao.findTransactionInfoById(id);
	}
	public TransactionDao getTransactionDao() {
		return transactionDao;
	}
	
	public ArrayList TransactionInfo(User user){
		return transactionDao.ListTransactionInfo(user);
		
	}
	@Resource
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

}
