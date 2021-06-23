package com.xworkz.perfume;

import java.util.List;

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
//		service.valideAndSave(dto);
		
		PerfumeDTO dto1 = service.validateAndGetByName(3);
		System.out.println(dto1);
		
		//service.validateAndUpdatePriceByName(1, "Fogg", 400.0);
		
//		service.validateAndDelete(3, "Ossum");
		
//		System.out.println("invoked getAllPerfume");
//		List<PerfumeDTO> dtos = service.getAllPerfume();
//		dtos.forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("invoked getPerfumeByPerfumeId");
//		PerfumeDTO perfumeDTOFromDB = service.getPerfumeByPerfumeId(1);
//		System.out.println(perfumeDTOFromDB);
//		
//		System.out.println();
//		System.out.println("invoked getCompanyNameByPerfumeName");
//		String cn = service.getCompanyNameByPerfumeName("Fogg");
//		System.out.println(cn);
		
		System.out.println("invoked getNameAndPriceByCompany");
		Object[] object = service.getNameAndPriceByCompany("yardley");
		for (Object object2 : object) {
			System.out.println(object2);
		}
		
	}
}
