package com.xworkz.sweet.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.sweet.dto.SweetDTO;

public class SweetDAOImpl implements SweetDAO {

	SessionFactory sessionFactory = null;
	Session session = null;

	@Override
	public void save(SweetDTO sweetDTO) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(sweetDTO);
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
	public SweetDTO getSweetByName(int id, String name) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			SweetDTO swtDTO = session.get(SweetDTO.class, id);

			return swtDTO;
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	@Override
	public void updateShapeByName(int id, String name, String shape) {

		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println((sessionFactory));
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			SweetDTO swtDTO = session.get(SweetDTO.class, id);
			swtDTO.setShape(shape);
			
			session.update(swtDTO);
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
		Transaction transaction =null;
		try {
		sessionFactory=HibernateUtil.getSessionFactory();
		//System.out.println((sessionFactory));
		session = sessionFactory.openSession();
		transaction =session.beginTransaction();
		SweetDTO swtDTO = session.get(SweetDTO.class, id);
		session.delete(swtDTO);
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
