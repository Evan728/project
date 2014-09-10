package com.efinance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.efinance.dao.LedgerDao;
import com.efinance.model.Ledger;


@Component("ledgerService")
@Transactional
public class LedgerService {
	
	private LedgerDao ledgerDao ;

   public void addLedger(Ledger ledger) {
		
	   ledgerDao.addLedger(ledger);
	}

	public void deleteLedger(Ledger ledger) {
		ledgerDao.deleteLedger(ledger);
		
	}

	public Ledger findLedgerById(Integer id) {
		
		return ledgerDao.findLedgerById(id);
	}

	public void updateLedger(Ledger ledger) {
		ledgerDao.updateLedger(ledger);
		
	}
	
	
	
	
	/*--------------------GET和SET方法---------------------------------------------*/
	
	
	public LedgerDao getLedgerDao() {
		return ledgerDao;
	}
    @Resource
	public void setLedgerDao(LedgerDao ledgerDao) {
		this.ledgerDao = ledgerDao;
	}
}
