package com.xworkz.perfume.dao;

import com.xworkz.perfume.dto.PerfumeDTO;

public interface PerfumeDAO {

	public void save(PerfumeDTO perfumeDTO);

	public PerfumeDTO getPerfumeByName(int id);

	public void updatePriceByName(int id, String name, double price);

	public void deleteByName(int id, String name);
}
