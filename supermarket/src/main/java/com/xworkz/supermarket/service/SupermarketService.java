package com.xworkz.supermarket.service;

import com.xworkz.supermarket.dto.SupermarketDTO;

public interface SupermarketService {
	
	void valideAndSave(SupermarketDTO supermarketDTO);

	public SupermarketDTO validateAndGetByName(int id, String name);
	
	public void validateAndUpdatePrice(int id, String name, double price);
	
	public void validateAndDelete(int id, String name);
}
