package com.xworkz.it_company.service;

import java.util.List;

import com.xworkz.it_company.dao.ItCompanyDAO;
import com.xworkz.it_company.dao.ItCompanyDAOImpl;
import com.xworkz.it_company.dto.ItCompanyDTO;

public class ItCompanyServiceImpl implements ItCompanyService{

	private ItCompanyDAO iDAO;
	
	public ItCompanyServiceImpl() {
		iDAO = new ItCompanyDAOImpl();
	}
	@Override
	public void validateAnSaveOrUpdate(ItCompanyDTO itCompanyDTO) {

		if (itCompanyDTO != null) {
			iDAO.saveOrUpdate(itCompanyDTO);
		} else {
			System.out.println("object cant be empty");
		}
	}

	@Override
	public void validateAndPersist(ItCompanyDTO itCompanyDTO) {


		if (itCompanyDTO != null) {
			iDAO.persist(itCompanyDTO);
		} else {
			System.out.println("object cant be empty");
		}
		
	}

	@Override
	public ItCompanyDTO validateAndLoad(int id) {
		if (id > 0) {
			return iDAO.load(id);
		} else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public void validateAndMerge(int id, String name, int rating) {
		// TODO Auto-generated method stub
		if (name != null) {
			iDAO.merge(id, name, rating);
		} else {
			System.out.println("Name cannot be null");
		}
	}

	@Override
	public void validateAndEvict(int id, String name) {
		// TODO Auto-generated method stub
		if (name != null) {
			iDAO.evict(id, name);
		} else {
			System.out.println("Name cant be null");
		}
	}
	@Override
	public List<ItCompanyDTO> getAllItCompany() {
		// TODO Auto-generated method stub
		return iDAO.getAllItCompany();
	}

}
