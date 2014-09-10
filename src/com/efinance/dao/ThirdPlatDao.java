package com.efinance.dao;

import com.efinance.model.ThirdPlat;


public interface ThirdPlatDao {
    public void addThirdPlat(ThirdPlat thirdPlat);
    public void deleteThirdPlat(ThirdPlat thirdPlat);
	public void updatThirdPlat(ThirdPlat thirdPlat);
	public ThirdPlat findAllThirdPlatById(int id);
}
