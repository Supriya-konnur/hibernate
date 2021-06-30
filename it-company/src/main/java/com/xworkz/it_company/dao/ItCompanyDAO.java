package com.xworkz.it_company.dao;

import java.util.List;

import com.xworkz.it_company.dto.ItCompanyDTO;

public interface ItCompanyDAO {

	public void saveOrUpdate(ItCompanyDTO itCompanyDTO);
	
	public void persist(ItCompanyDTO itCompanyDTO);

	public ItCompanyDTO load(int id);

	public void merge(int id, String name, int rating);

	public void evict(int id, String name);
	
	public List<ItCompanyDTO> getAllItCompany();
}
