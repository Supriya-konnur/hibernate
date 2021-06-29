package com.xworkz.supermarket.dao;

import com.xworkz.supermarket.dto.SupermarketDTO;

public interface SupermarketDAO {
	
	public void save(SupermarketDTO supermarketDTO);

	public SupermarketDTO getSupermarketByName(int id, String name);

	public void updatePriceByName(int id, String name, double price);

	public void deleteByName(int id, String name);
	
}
