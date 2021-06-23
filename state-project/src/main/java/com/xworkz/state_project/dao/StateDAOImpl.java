package com.xworkz.state_project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.singleton.HibernateUtil;
import com.xworkz.state_project.dto.StateDTO;

public class StateDAOImpl implements StateDAO {
	SessionFactory sessionFactory = null;
	Session session = null;

	@Override
	public void save(StateDTO stateDTO) {
		// TODO Auto-generated method stub

		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(stateDTO);
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
	public StateDTO getStateName(int id) {
		// TODO Auto-generated method stub
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			StateDTO stateDTO = session.get(StateDTO.class, id);

			return stateDTO;
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	@Override
	public void updateNoOfDistrictByName(int id, String name, int district) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println((sessionFactory));
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			StateDTO stateDTO = session.get(StateDTO.class, id);
			stateDTO.setNo_of_district(district);
			session.update(stateDTO);
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
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			StateDTO stateDTO = session.get(StateDTO.class, id);
			session.delete(stateDTO);
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
	public List<StateDTO> getAllState() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query =session.createQuery("select dto from StateDTO dto");
			List<StateDTO> dtos = query.list();
			return dtos;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if(session !=null) {
				session.close();
			}
		}
		return null;
	}

}
