package com.xworkz.perfume.service;

import java.util.List;

import com.xworkz.perfume.dao.PerfumeDAO;
import com.xworkz.perfume.dao.PerfumeDAOImpl;
import com.xworkz.perfume.dto.PerfumeDTO;

public class PerfumeServiceImpl implements PerfumeService {
	private PerfumeDAO pDAO;

	public PerfumeServiceImpl() {
		pDAO = new PerfumeDAOImpl();
	}

	@Override
	public void valideAndSave(PerfumeDTO perfumeDTO) {
		if (perfumeDTO != null) {
			pDAO.save(perfumeDTO);
		} else {
			System.out.println("object cant be empty");
		}

	}

	@Override
	public PerfumeDTO validateAndGetByName(int id) {
		if (id > 0) {
			return pDAO.getPerfumeByName(id);
		} else {
			System.out.println("Name cant be null");
		}
		return null;

	}

	@Override
	public void validateAndUpdatePriceByName(int id, String name, double price) {
		if (name != null) {
			pDAO.updatePriceByName(id, name, price);
		} else {
			System.out.println("Name cannot be null");
		}

	}

	@Override
	public void validateAndDelete(int id, String name) {
		if (name != null) {
			pDAO.deleteByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}

	}

	@Override
	public List<PerfumeDTO> getAllPerfume() {
		// TODO Auto-generated method stub
		return pDAO.getAllPerfume();
	}

	@Override
	public PerfumeDTO getPerfumeByPerfumeId(int id) {
		// TODO Auto-generated method stub
		return pDAO.getPerfumeByPerfumeId(id);
	}

	@Override
	public String getCompanyNameByPerfumeName(String perfumeName) {

		return pDAO.getCompanyNameByPerfumeName(perfumeName);
	}

	@Override
	public Object[] getNameAndPriceByCompany(String company) {
		// TODO Auto-generated method stub
		return pDAO.getNameAndPriceByCompany(company);
	}

	@Override
	public List<Object[]> getAllNameAndPriceByCompany(String cname) {
		// TODO Auto-generated method stub
		return pDAO.getAllNameAndPriceByCompany(cname);
	}

}
