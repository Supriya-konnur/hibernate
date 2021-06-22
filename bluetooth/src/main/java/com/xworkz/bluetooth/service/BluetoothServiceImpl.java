package com.xworkz.bluetooth.service;

import com.xworkz.bluetooth.dao.BluetoothDAO;
import com.xworkz.bluetooth.dao.BluetoothDAOImp;
import com.xworkz.bluetooth.dto.BluetoothDTO;

public class BluetoothServiceImpl implements BluetoothService {
	private BluetoothDAO bluetoothDAO;

	public BluetoothServiceImpl() {
		bluetoothDAO = new BluetoothDAOImp();
	}

	@Override
	public void validateAndSave(BluetoothDTO bluetoothDTO) {
		// TODO Auto-generated method stub
		if (bluetoothDTO != null) {
			if (bluetoothDTO.getRange() != null) {
				bluetoothDAO.save(bluetoothDTO);
			}

		}

	}

	@Override
	public BluetoothDTO getBlueToothById(int id) {
		if (id > 0) {
			return bluetoothDAO.getBlueToothById(id);
		}
		return null;
	}

	@Override
	public void updateCompanyByBluetoothName(String bluetoothName, String company) {
		// TODO Auto-generated method stub
		if (bluetoothName != null && company != null) {
			bluetoothDAO.updateCompanyByBluetoothName(bluetoothName, company);
		}
	}

	@Override
	public void validateAndDeleteById(int id) {
		// TODO Auto-generated method stub
		if (id > 0) {
			bluetoothDAO.deleteById(id);

		}

	}

}
