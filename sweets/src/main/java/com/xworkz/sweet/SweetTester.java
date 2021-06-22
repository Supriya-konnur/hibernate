package com.xworkz.sweet;

import com.xworkz.sweet.dao.SweetDAOImpl;
import com.xworkz.sweet.dto.SweetDTO;
import com.xworkz.sweet.service.SweetService;
import com.xworkz.sweet.service.SweetServiceImpl;

public class SweetTester {
public static void main(String[] args) {
	SweetDTO sDTO = new SweetDTO();
	sDTO.setSweet_id(4);
	sDTO.setName("KajuBurffy");
	sDTO.setColor("Milky White");
	sDTO.setPrice(80.0);
	sDTO.setShape("diamond");
	
	SweetService service = new SweetServiceImpl();
//	service.valideAndSave(sDTO);
	
	SweetDTO sDTO1 = service.validateAndGetByName(3, "Peda");

	System.out.println(sDTO1);
	
//	  service.validateAndUpdateShape(1, "Jamun", "squar");
	  
	  service.validateAndDelete(4, "KajuBurffy");
}
	
}
