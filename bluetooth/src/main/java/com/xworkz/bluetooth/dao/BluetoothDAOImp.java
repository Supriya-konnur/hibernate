package com.xworkz.bluetooth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.bluetooth.dto.BluetoothDTO;

public class BluetoothDAOImp implements BluetoothDAO{

	@Override
	public void save(BluetoothDTO bluetoothDTO) {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(BluetoothDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(bluetoothDTO);
		transaction.commit();
		session.close();
		factory.close();
		
	}

	@Override
	public BluetoothDTO getBlueToothById(int id) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(BluetoothDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		BluetoothDTO bluetoothDTO = session.get(BluetoothDTO.class, id);
		session.close();
		factory.close();
		return bluetoothDTO;
	}

	@Override
	public void updateCompanyByBluetoothName(String bluetoothName, String company) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(BluetoothDTO.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		BluetoothDTO bluetoothDTO = session.get(BluetoothDTO.class, 3);
		bluetoothDTO.setCompanyName(company);
		if (bluetoothDTO != null) {
			if (bluetoothName.equalsIgnoreCase(bluetoothDTO.getBluetoothName())) {
				bluetoothDTO.setCompanyName(company);
				session.update(bluetoothDTO);
			}

		}

		transaction.commit();
		session.close();
		factory.close();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(BluetoothDTO.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		BluetoothDTO bluetoothDTO1 = session.get(BluetoothDTO.class,id);
		Transaction transaction = session.beginTransaction();
		session.delete(bluetoothDTO1);
		transaction.commit();
		session.close();
		factory.close();
		
	}

	

}
