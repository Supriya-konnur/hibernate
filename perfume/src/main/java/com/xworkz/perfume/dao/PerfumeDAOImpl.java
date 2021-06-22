package com.xworkz.perfume.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.perfume.dto.PerfumeDTO;
import com.xworkz.singleton.HibernateUtil;

public class PerfumeDAOImpl implements PerfumeDAO {

	SessionFactory sessionFactory = null;
	Session session = null;

	@Override
	public void save(PerfumeDTO perfumeDTO) {

		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(perfumeDTO);
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
	public PerfumeDTO getPerfumeByName(int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			PerfumeDTO perfumeDTO = session.get(PerfumeDTO.class, id);

			return perfumeDTO;
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	@Override
	public void updatePriceByName(int id, String name, double price) {
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println((sessionFactory));
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			PerfumeDTO perfumeDTO = session.get(PerfumeDTO.class, id);
			perfumeDTO.setPerfumePrice(price);

			session.update(perfumeDTO);
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

		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			PerfumeDTO perfumeDTO = session.get(PerfumeDTO.class, id);
			session.delete(perfumeDTO);
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}

		}

	}

}
