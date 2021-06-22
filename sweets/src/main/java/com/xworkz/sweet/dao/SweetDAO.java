package com.xworkz.sweet.dao;

import com.xworkz.sweet.dto.SweetDTO;

public interface SweetDAO {
	
	public void save(SweetDTO sweetDTO);

	public SweetDTO getSweetByName(int id, String name);

	public void updateShapeByName(int id, String name, String shape);

	public void deleteByName(int id, String name);
}
