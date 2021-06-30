package com.xworkz.it_company.service;

import java.util.List;

import com.xworkz.it_company.dto.ItCompanyDTO;

public interface ItCompanyService {

	public void validateAnSaveOrUpdate(ItCompanyDTO itCompanyDTO);

	public void validateAndPersist(ItCompanyDTO itCompanyDTO);

	public ItCompanyDTO validateAndLoad(int id);

	public void validateAndMerge(int id, String name, int rating);

	public void validateAndEvict(int id, String name);

	public List<ItCompanyDTO> getAllItCompany();
}
