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
			Query query = session.getNamedQuery("getAllPerfume");
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
//		String hql = "select dto from PerfumeDTO dto where dto.perfumeId=:pid";
		PerfumeDTO perfumeDTO = new PerfumeDTO();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("getPerfumeByPerfumeId");
			query.setParameter("pid", id);
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
//		String hql = "select dto.perfumeCompany from PerfumeDTO  dto where dto.perfumeName=:pm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("getCompanyNameByPerfumeName");
			query.setParameter("pm", pname);
			companyName = (String) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			} else {

				System.out.println("session cannot be closed");
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return companyName;
	}

	@Override
	public Object[] getNameAndPriceByCompany(String company) {
		Session session = null;
		Object[] nameAndPrice = null;
//		String hql = "select dto.perfumeName, dto.perfumePrice from PerfumeDTO dto where dto.perfumeCompany=:pc";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("getNameAndPriceByCompany");
			query.setParameter("pc", company);
			nameAndPrice = (Object[]) query.uniqueResult();
			return nameAndPrice;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			} else {

				System.out.println("session cannot be closed");
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return null;
	}

	Transaction transaction = null;

	@Override
	public List<Object[]> getAllNameAndPriceByCompany(String cname) {
		Session session = null;
		List<Object[]> allNameAndPrice = null;
//		String hql = "select dto.perfumeName, dto.perfumePrice from PerfumeDTO dto where dto.perfumeCompany=:cm";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.getNamedQuery("getAllNameAndPriceByCompany");
			query.setParameter("cm", cname);
			allNameAndPrice = (List<Object[]>) query.list();
			return allNameAndPrice;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			} else {

				System.out.println("session cannot be closed");
			}
			if (HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return null;
	}

	@Override
	public int updatePriceByName(String name, double price) {
		// TODO Auto-generated method stub

//		String hql = "update PerfumeDTO dto set dto.perfumePrice =:pc where dto.perfumeName=:nm";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updatePriceByName");
			query.setParameter("pc", price);
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
	public int updateCompanyByName(String name, String company) {
		// TODO Auto-generated method stub
//		String hql = "update PerfumeDTO dto set dto.perfumeCompany =:pc where dto.perfumeName=:nm ";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateCompanyByName");
			
			query.setParameter("pc", name);
			query.setParameter("nm", company);
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
//		String hql = "delete from PerfumeDTO dto where dto.perfumeName=:nm";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
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

	@Override
	public int deleteByPrice(double price) {
		// TODO Auto-generated method stub
//		String hql = "delete from PerfumeDTO dto where dto.perfumePrice=:pc";

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteByPrice");
			query.setParameter("pc", price);
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
