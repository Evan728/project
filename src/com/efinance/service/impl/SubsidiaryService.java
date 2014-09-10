package com.efinance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.efinance.dao.SubsidiaryDao;
import com.efinance.model.Subsidiary;

@Component("subsidiaryService")
@Transactional
public class SubsidiaryService {

	private SubsidiaryDao subsidiaryDao;
	
	
	public void addSubsidiary(Subsidiary subsidiary) {
		 subsidiaryDao.addSubsidiary(subsidiary);
		
	}

	public void deleteSubsidiary(Subsidiary subsidiary) {
		subsidiaryDao.deleteSubsidiary(subsidiary);
		
	}

	public Subsidiary findAllSubsidiaryById(Integer id) {
		
		return subsidiaryDao.findAllSubsidiaryById(id);
	}

	public void updatSubsidiary(Subsidiary subsidiary) {
		subsidiaryDao.updatSubsidiary(subsidiary);
		}

	public SubsidiaryDao getSubsidiaryDao() {
		return subsidiaryDao;
	}
@Resource
	public void setSubsidiaryDao(SubsidiaryDao subsidiaryDao) {
		this.subsidiaryDao = subsidiaryDao;
	}
	
	
	
}
