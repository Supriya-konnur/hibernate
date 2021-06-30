package com.xworkz.it_company;

import java.util.List;

import com.xworkz.it_company.dto.ItCompanyDTO;
import com.xworkz.it_company.service.ItCompanyService;
import com.xworkz.it_company.service.ItCompanyServiceImpl;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ItCompanyDTO dto = new ItCompanyDTO();
		dto.setCompanyName("Google");
		dto.setLocation("Bangalore");
		dto.setRating(5);
		
		ItCompanyService service = new ItCompanyServiceImpl();
	//	service.validateAnSaveOrUpdate(dto);
//		service.validateAndPersist(dto);
		 
//		ItCompanyDTO dto2 = service.validateAndLoad(5);
//		System.out.println(dto2);
//		
//		service.validateAndMerge(4, "Infosys", 5);
		
//		service.validateAndEvict(2, "Accenture");
		
		List<ItCompanyDTO> dtos = service.getAllItCompany();
		System.out.println(dtos);
	}

}
