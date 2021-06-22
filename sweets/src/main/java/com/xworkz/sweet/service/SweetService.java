package com.xworkz.sweet.service;

import com.xworkz.sweet.dto.SweetDTO;

public interface SweetService {
	void valideAndSave(SweetDTO sweetDTO);

	public SweetDTO validateAndGetByName(int id, String name);
	
	public void validateAndUpdateShape(int id, String name, String shape);
	
	public void validateAndDelete(int id, String name);

}
