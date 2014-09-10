package com.efinance.service;

import com.efinance.model.Ledger;
import com.efinance.model.ThirdPlat;

public interface NetbankService {

	public void update(Ledger ledger, ThirdPlat thirdPlat);
}