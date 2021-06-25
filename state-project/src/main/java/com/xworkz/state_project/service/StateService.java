package com.xworkz.state_project.service;


import java.util.List;

import com.xworkz.state_project.dto.StateDTO;

public interface StateService {
	void valideAndSave(StateDTO stateDTO);

	public StateDTO validateAndGetById(int id);
	
	public void validateAndUpdatePriceByName(int id, String name, int district);
	
	public void validateAndDelete(int id, String name);
	
	public List<StateDTO> getAllState();

	int updateNoOfDistrictByName(String name, int district);

	int deleteByName(String name);
}
