package com.xworkz.supermarket.service;

import com.xworkz.supermarket.dao.SupermarketDAO;
import com.xworkz.supermarket.dao.SupermarketDAOImpl;
import com.xworkz.supermarket.dto.SupermarketDTO;


public class SupermarketServiceImpl implements SupermarketService{

	private SupermarketDAO smDAO;
	
	public SupermarketServiceImpl() {
		smDAO = new  SupermarketDAOImpl();
	}
	
	@Override
	public void valideAndSave(SupermarketDTO supermarketDTO) {
		// TODO Auto-generated method stub
		if (supermarketDTO != null) {
			smDAO.save(supermarketDTO);
		} else {
			System.out.println("object cant be empty");
		}	
	}

	@Override
	public SupermarketDTO validateAndGetByName(int id, String name) {
		// TODO Auto-generated method stub
		if (name != null) {
			return smDAO.getSupermarketByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public void validateAndUpdatePrice(int id, String name, double price) {
		// TODO Auto-generated method stub
		if (name != null) {
			smDAO.updatePriceByName(id, name, price);
		} else {
			System.out.println("Name cannot be null");
		}
		
	}

	@Override
	public void validateAndDelete(int id, String name) {
		// TODO Auto-generated method stub
		if (name != null) {
			smDAO.deleteByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}
	}

}
