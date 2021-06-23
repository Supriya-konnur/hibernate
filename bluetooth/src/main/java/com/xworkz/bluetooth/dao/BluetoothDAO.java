package com.xworkz.bluetooth.dao;

import java.util.List;

import com.xworkz.bluetooth.dto.BluetoothDTO;


public interface BluetoothDAO {

	public void save(BluetoothDTO bluetoothDTO);
	
	public BluetoothDTO getBlueToothById(int id);
	
	public void updateCompanyByBluetoothName(String bluetoothName, String company);

	void deleteById(int id);
	
	}
