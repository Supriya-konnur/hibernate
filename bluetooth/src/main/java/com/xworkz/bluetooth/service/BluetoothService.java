package com.xworkz.bluetooth.service;

import com.xworkz.bluetooth.dto.BluetoothDTO;

public interface BluetoothService {

	void validateAndSave(BluetoothDTO bluetoothDTO);


	
	public BluetoothDTO getBlueToothById(int id);

	public void updateCompanyByBluetoothName(String bluetoothName, String company);

	void validateAndDeleteById(int id);
}
