package com.xworkz.state_project.dao;

import java.util.List;

import com.xworkz.state_project.dto.StateDTO;

public interface StateDAO {

	public void save(StateDTO stateDTO);

	public StateDTO getStateName(int id);

	public void updateNoOfDistrictByName(int id, String name, int district);

	public void deleteByName(int id, String name);
	
	public List<StateDTO> getAllState();
	
	int updateNoOfDistrictByName(String name, int district);

	int deleteByName(String name);

}
