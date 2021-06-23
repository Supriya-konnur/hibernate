package com.xworkz.perfume.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	@Override
	public List<PerfumeDTO> getAllPerfume() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select dto from PerfumeDTO dto");
			List<PerfumeDTO> dtos = query.list();
			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public PerfumeDTO getPerfumeByPerfumeId(int id) {
		Session session = null;
		String hql = "select dto from PerfumeDTO dto where dto.perfumeId=" + id + "";
		PerfumeDTO perfumeDTO = new PerfumeDTO();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			perfumeDTO = (PerfumeDTO) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			} else {
				System.out.println("session cannot be closed");
			}
		}
		return perfumeDTO;

		
	}

	@Override
	public String getCompanyNameByPerfumeName(String pname) {
		Session session = null;
		String companyName = null;
		String hql = "select dto.perfumeCompany from PerfumeDTO  dto where dto.perfumeName='"+pname+"'";
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			companyName = (String) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}else {
				
				System.out.println("session cannot be closed");
			}
			if(HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return companyName;
	}

	@Override
	public Object[] getNameAndPriceByCompany(String company) {
		Session session = null;
		Object[] nameAndPrice = null;
		String hql = "select dto.perfumeName, dto.perfumePrice from PerfumeDTO dto where dto.perfumeCompany='"+company+"'";
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			nameAndPrice = (Object[]) query.uniqueResult();
			return nameAndPrice;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}else {
				
				System.out.println("session cannot be closed");
			}
			if(HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return null;
	}

	@Override
	public List<Object[]> getAllNameAndPriceByCompany(String cname) {
		Session session = null;
		List<Object[]> allNameAndPrice = null;
		String hql = "select dto.perfumeName, dto.perfumePrice from PerfumeDTO dto where dto.perfumeCompany='"+cname+"'";
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			allNameAndPrice = (List<Object[]>) query.list();
			return allNameAndPrice;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}else {
				
				System.out.println("session cannot be closed");
			}
			if(HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return null;
	}

}
