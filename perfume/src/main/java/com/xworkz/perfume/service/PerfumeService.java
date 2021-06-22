package com.xworkz.perfume.service;

import com.xworkz.perfume.dto.PerfumeDTO;

public interface PerfumeService {
	void valideAndSave(PerfumeDTO perfumeDTO);

	public PerfumeDTO validateAndGetByName(int id);
	
	public void validateAndUpdatePriceByName(int id, String name, double price);
	
	public void validateAndDelete(int id, String name);
}
