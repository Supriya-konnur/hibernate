package com.xworkz.sweet.service;

import com.xworkz.sweet.dao.SweetDAO;
import com.xworkz.sweet.dao.SweetDAOImpl;
import com.xworkz.sweet.dto.SweetDTO;

public class SweetServiceImpl implements SweetService {
	private SweetDAO sDAO;

	public SweetServiceImpl() {
		sDAO = new SweetDAOImpl();
	}

	@Override
	public void valideAndSave(SweetDTO sweetDTO) {
		if (sweetDTO != null) {
			sDAO.save(sweetDTO);
		} else {
			System.out.println("object cant be empty");
		}

	}

	@Override
	public SweetDTO validateAndGetByName(int id, String name) {
		if (name != null) {
			return sDAO.getSweetByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}
		return null;

	}

	@Override
	public void validateAndUpdateShape(int id, String name, String shape) {
		if (name != null) {
			sDAO.updateShapeByName(id, name, shape);
		} else {
			System.out.println("Name cannot be null");
		}

	}

	@Override
	public void validateAndDelete(int id, String name) {
		if (name != null) {
			sDAO.deleteByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}

	}

}
