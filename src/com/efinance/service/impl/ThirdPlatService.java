package com.efinance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.efinance.dao.ThirdPlatDao;
import com.efinance.model.ThirdPlat;


@Component("thirdPlatService")
@Transactional
public class ThirdPlatService {
	private ThirdPlatDao thirdPlatDao;
	
	
	public void addThirdPlat(ThirdPlat thirdPlat) {
		thirdPlatDao.addThirdPlat(thirdPlat);
	}
	
    public void deleteThirdPlat(ThirdPlat thirdPlat){
    	thirdPlatDao.deleteThirdPlat(thirdPlat);
    }
	public void updatThirdPlat(ThirdPlat thirdPlat){
		thirdPlatDao.updatThirdPlat(thirdPlat);
	}
	public ThirdPlat findAllThirdPlatById(int id){
		return thirdPlatDao.findAllThirdPlatById(id);
	}
	

	public ThirdPlatDao getThirdPlatDao() {
		return thirdPlatDao;
	}
@Resource
	public void setThirdPlatDao(ThirdPlatDao thirdPlatDao) {
		this.thirdPlatDao = thirdPlatDao;
	}
	
	

}
