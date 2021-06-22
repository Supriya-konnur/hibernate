package com.xworkz.bluetooth;

import com.xworkz.bluetooth.dto.BluetoothDTO;
import com.xworkz.bluetooth.service.BluetoothService;
import com.xworkz.bluetooth.service.BluetoothServiceImpl;

public class BluetoothTester {
public static void main(String[] args) {
	
	BluetoothDTO bluetoothDTO = new BluetoothDTO();
	
	bluetoothDTO.setBluetoothId(3);
	bluetoothDTO.setBluetoothName("Boat");
	bluetoothDTO.setCompanyName("boat-33");
	bluetoothDTO.setRange("8m");
	
	BluetoothService bluetoothService = new BluetoothServiceImpl();
//	bluetoothService.validateAndSave(bluetoothDTO);
	
	 BluetoothDTO bluetoothDTO1 = bluetoothService.getBlueToothById(1);
	  System.out.println(bluetoothDTO1);
	  
	  bluetoothService.updateCompanyByBluetoothName("boat-33" ,"sony");
	  //bluetoothService.validateAndDeleteById(2);
}
}
