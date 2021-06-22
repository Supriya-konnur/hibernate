package com.xworkz.perfume;

import com.xworkz.perfume.dto.PerfumeDTO;
import com.xworkz.perfume.service.PerfumeService;
import com.xworkz.perfume.service.PerfumeServiceImpl;

public class PerfumeTester {
	public static void main(String[] args) {
		PerfumeDTO dto = new PerfumeDTO();
		dto.setPerfumeName("Ossum");
		dto.setPerfumePrice(150.0);
		dto.setPerfumeCompany("os");
		
		PerfumeService service = new PerfumeServiceImpl();
		//service.valideAndSave(dto);
		
		PerfumeDTO dto1 = service.validateAndGetByName(3);
		System.out.println(dto1);
		
		//service.validateAndUpdatePriceByName(1, "Fogg", 400.0);
		
		service.validateAndDelete(3, "Ossum");
	}
}
