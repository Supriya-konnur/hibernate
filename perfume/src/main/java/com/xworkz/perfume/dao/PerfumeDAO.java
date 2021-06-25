package com.xworkz.perfume.dao;

import java.util.List;

import com.xworkz.perfume.dto.PerfumeDTO;

public interface PerfumeDAO {

	public void save(PerfumeDTO perfumeDTO);

	public PerfumeDTO getPerfumeByName(int id);

	public void updatePriceByName(int id, String name, double price);

	public void deleteByName(int id, String name);
	
	public List<PerfumeDTO> getAllPerfume();

	public PerfumeDTO getPerfumeByPerfumeId(int id);

	public String getCompanyNameByPerfumeName(String perfumeName);

	public Object[] getNameAndPriceByCompany(String pname);
	
	public List<Object[]> getAllNameAndPriceByCompany(String cname);
	
	int updatePriceByName(String name,double price);

	int updateCompanyByName(String name, String company);

	int deleteByName(String name);

	int deleteByPrice(double price);

}
