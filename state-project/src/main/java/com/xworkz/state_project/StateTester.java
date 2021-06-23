package com.xworkz.state_project;

import java.util.List;

import com.xworkz.state_project.dto.StateDTO;
import com.xworkz.state_project.service.StateService;
import com.xworkz.state_project.service.StateServiceImpl;

public class StateTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StateDTO dto = new StateDTO();
		dto.setState_name("Kerala");
		dto.setLanguage("Malayalam");
		dto.setCapital_name("Thiruvananthapuram");
		dto.setNo_of_district(11);

		StateService service =new StateServiceImpl();
		//service.valideAndSave(dto);
		
		StateDTO dto1 =service.validateAndGetById(1);
		System.out.println(dto1);
		
//		service.validateAndUpdatePriceByName(2, "Andra Pradesh", 14);
//		
//		service.validateAndDelete(4, "Maharastra");
		
		List<StateDTO> dtos = service.getAllState();
		
		dtos.forEach(System.out::println);
	}

}
