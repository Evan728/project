package com.efinance.dao;

import com.efinance.model.Ledger;


public interface LedgerDao {
	
	
	public void addLedger(Ledger ledger);							   
	public void updateLedger(Ledger ledger);                       
	public void deleteLedger(Ledger ledger);                      
	public Ledger findLedgerById(Integer id);
}
