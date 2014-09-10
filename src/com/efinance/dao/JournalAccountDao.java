package com.efinance.dao;

import java.util.ArrayList;

import com.efinance.model.JournalAccount;
import com.efinance.model.User;

import antlr.collections.List;


public interface JournalAccountDao {
	public void addJournalAccount(JournalAccount journalAccount);							   
	public void updateJournalAccount(JournalAccount journalAccount);                       
	public void deleteJournalAccount(JournalAccount journalAccount);                      
	public JournalAccount findJournalAccountById(Integer id);
    public ArrayList  ListJournalAccount(User user);
}
