package com.efinance.dao;

import com.efinance.model.Subsidiary;

public interface SubsidiaryDao {
	public void addSubsidiary(Subsidiary subsidiary);
    public void deleteSubsidiary(Subsidiary subsidiary);
	public void updatSubsidiary(Subsidiary subsidiary);
	public Subsidiary  findAllSubsidiaryById(Integer id);

}
