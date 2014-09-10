package com.efinance.dao;

import org.springframework.stereotype.Repository;

import com.efinance.model.Ledger;
import com.efinance.model.ThirdPlat;


@Repository
public interface NetbankDao {
	public void saveOrUpdate(Ledger ledger, ThirdPlat thirdPlat);
}

