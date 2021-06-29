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
			stateDTO.setNoOfDistrict(district);
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
			Query query =session.getNamedQuery("getAllState");
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
	Transaction transaction =null;
	@Override
	public int updateNoOfDistrictByName(String name, int district) {
		// TODO Auto-generated method stub
//		String hql = "update StateDTO dto set dto.noOfDistrict =:dc where dto.stateName=:nm";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateNoOfDistrictByName");
			query.setParameter("dc", district);
			query.setParameter("nm", name);
			int r = query.executeUpdate();

			transaction.commit();
			return r;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}

		}
		return 0;
	}

	@Override
	public int deleteByName(String name) {
		// TODO Auto-generated method stub
		
//		String hql = "delete from StateDTO dto where dto.stateName=:nm";

		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction  = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByName");
			query.setParameter("nm", name);
			int n = query.executeUpdate();

			transaction.commit();
			return n;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}

		}
		return 0;
	}

}
