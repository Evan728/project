package com.efinance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.efinance.dao.NetbankDao;
import com.efinance.model.Ledger;
import com.efinance.model.ThirdPlat;
import com.efinance.service.NetbankService;

@Component("netbankService")
public class NetbankServiceImpl implements NetbankService{
	@Resource
	private NetbankDao netbankDao;
	
	
	public NetbankDao getNetbankDao() {
		return netbankDao;
	}


	public void setNetbankDao(NetbankDao netbankDao) {
		this.netbankDao = netbankDao;
	}

	public void update(Ledger ledger, ThirdPlat thirdPlat) {
		netbankDao.saveOrUpdate(ledger, thirdPlat);
	}
}
