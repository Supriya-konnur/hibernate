package com.xworkz.perfume.service;

import java.util.List;

import com.xworkz.perfume.dto.PerfumeDTO;

public interface PerfumeService {
	void valideAndSave(PerfumeDTO perfumeDTO);

	public PerfumeDTO validateAndGetByName(int id);

	public void validateAndUpdatePriceByName(int id, String name, double price);

	public void validateAndDelete(int id, String name);

	public List<PerfumeDTO> getAllPerfume();

	public PerfumeDTO getPerfumeByPerfumeId(int id);

	public String getCompanyNameByPerfumeName(String perfumeName);

	public Object[] getNameAndPriceByCompany(String company);

	public List<Object[]> getAllNameAndPriceByCompany(String cname);

	int updatePriceByName(String name, double price);

	int updateCompanyByName(String name, String company);

	int deleteByName(String name);

	int deleteByPrice(double price);

}
