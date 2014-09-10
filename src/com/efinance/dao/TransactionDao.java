package com.efinance.dao;

import java.util.ArrayList;


import com.efinance.model.TransactionInfo;
import com.efinance.model.User;


public interface TransactionDao {
	public void addTransactionInfo(TransactionInfo transaction);							   
	public void updateTransactionInfo(TransactionInfo transaction);                       
	public void deleteTransactionInfo(TransactionInfo transaction);                      
	public TransactionInfo findTransactionInfoById(Integer id);
    public ArrayList  ListTransactionInfo(User user);
}
