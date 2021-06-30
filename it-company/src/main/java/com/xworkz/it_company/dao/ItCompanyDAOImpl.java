package com.xworkz.it_company.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.xworkz.it_company.dto.ItCompanyDTO;
import com.xworkz.singleton.HibernateUtil;

public class ItCompanyDAOImpl implements ItCompanyDAO{
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction transaction = null;
	@Override
	public void saveOrUpdate(ItCompanyDTO itCompanyDTO) {
		// TODO Auto-generated method stub
//		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(itCompanyDTO);
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
	public void persist(ItCompanyDTO itCompanyDTO) {
		// TODO Auto-generated method stub
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(itCompanyDTO);
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
	public ItCompanyDTO load(int id) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			ItCompanyDTO itCompanyDTO = session.load(ItCompanyDTO.class, id);

			return itCompanyDTO;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public void merge(int id, String name, int rating) {
		// TODO Auto-generated method stub
		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println((sessionFactory));
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			ItCompanyDTO itCompanyDTO = session.get(ItCompanyDTO.class, id);
			itCompanyDTO.setRating(rating);

			session.merge(itCompanyDTO);
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
	public void evict(int id, String name) {
		// TODO Auto-generated method stub
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			ItCompanyDTO itCompanyDTO = session.get(ItCompanyDTO.class, id);
			session.evict(itCompanyDTO);
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

	@Override
	public List<ItCompanyDTO> getAllItCompany() {
		// TODO Auto-generated method stub
		List<ItCompanyDTO> itCompanyDTOs = new ArrayList<ItCompanyDTO>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
//			Query query = session.getNamedQuery("getAllItCompany");
//			List<ItCompanyDTO> dtos = query.list();
			Criteria query =session.createCriteria(ItCompanyDTO.class);
			query.addOrder(Order.asc("companyName"));
			itCompanyDTOs= query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}else {
				System.out.println("session can not be closed");
			}
		}
		return itCompanyDTOs;
	}

}
