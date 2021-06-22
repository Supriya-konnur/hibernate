package com.xworkz.supermarket.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.supermarket.dto.SupermarketDTO;


public class SupermarketDAOImpl implements SupermarketDAO {

	SessionFactory sessionFactory = null;
	Session session = null;
	
	@Override
	public void save(SupermarketDTO supermarketDTO) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(supermarketDTO);
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

	@Override
	public SupermarketDTO getSupermarketByName(int id, String name) {
		// TODO Auto-generated method stub
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			SupermarketDTO sDTO = session.get(SupermarketDTO.class, id);

			return sDTO;
		} finally {
			if (session != null) {
				session.close();
			}

		}
		
	}

	@Override
	public void updatePriceByName(int id, String name, double price) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println((sessionFactory));
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			SupermarketDTO sDTO = session.get(SupermarketDTO.class, id);
			sDTO.setPrice(price);
			
			session.update(sDTO);
			transaction.commit();


		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}	
	}

	@Override
	public void deleteByName(int id, String name) {
		// TODO Auto-generated method stub
		Transaction transaction =null;
		try {
		sessionFactory=HibernateUtil.getSessionFactory();
		//System.out.println((sessionFactory));
		session = sessionFactory.openSession();
		transaction =session.beginTransaction();
		SupermarketDTO sDTO = session.get(SupermarketDTO.class, id);
		session.delete(sDTO);
		transaction.commit();
		
		}catch (HibernateException e) {
			if(transaction!=null) {
				transaction.rollback();
				}
		}
		finally{
			if(session!=null) {
			session.close();
			}
			if(sessionFactory!=null) {
				sessionFactory.close();
				}
			
			
		}
	}

}
