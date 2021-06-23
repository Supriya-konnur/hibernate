package com.xworkz.state_project.service;

import java.util.List;

import com.xworkz.state_project.dao.StateDAO;
import com.xworkz.state_project.dao.StateDAOImpl;
import com.xworkz.state_project.dto.StateDTO;

public class StateServiceImpl implements StateService{
private StateDAO sDAO;

public StateServiceImpl() {
	sDAO= new StateDAOImpl();
}
	@Override
	public void valideAndSave(StateDTO stateDTO) {
		// TODO Auto-generated method stub
		if (stateDTO != null) {
			sDAO.save(stateDTO);
		} else {
			System.out.println("object cant be empty");
		}

	}

	@Override
	public StateDTO validateAndGetById(int id) {
		// TODO Auto-generated method stub
		if (id > 0) {
			return sDAO.getStateName(id);
		} else {
			System.out.println("Name cant be null");
		}
		return null;

		
	}

	@Override
	public void validateAndUpdatePriceByName(int id, String name, int district) {
		// TODO Auto-generated method stub
		if (name != null) {
			sDAO.updateNoOfDistrictByName(id, name, district);
		} else {
			System.out.println("Name cannot be null");
		}
	}

	@Override
	public void validateAndDelete(int id, String name) {
		// TODO Auto-generated method stub
		if (name != null) {
			sDAO.deleteByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}

	}
	@Override
	public List<StateDTO> getAllState() {
		// TODO Auto-generated method stub
		return sDAO.getAllState();
	}

}
