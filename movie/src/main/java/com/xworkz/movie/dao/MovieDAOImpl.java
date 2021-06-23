package com.xworkz.movie.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.movie.dto.MovieDTO;
import com.xworkz.singleton.HibernateUtil;


public class MovieDAOImpl implements MovieDAO {

	SessionFactory sessionFactory = null;
	Session session = null;

	@Override
	public void save(MovieDTO movieDTO) {
		Transaction transaction = null;
		try {

			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(movieDTO);
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
	public MovieDTO getMovieName(int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			MovieDTO movieDTO = session.get(MovieDTO.class, id);

			return movieDTO;
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void updateRatingByName(int id, String name, int rating) {
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println(sessionFactory);
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			MovieDTO movieDTO = session.get(MovieDTO.class, id);
			movieDTO.setMovieRating(rating);
			session.update(movieDTO);
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
			MovieDTO movieDTO = session.get(MovieDTO.class, id);
			session.delete(movieDTO);
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
	public List<MovieDTO> getAllMovies() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("select dto from MovieDTO dto");
			List<MovieDTO> dtos = query.list();
			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public MovieDTO getMovieByMovieId(int id) {
		Session session = null;
		String hql = "select dto from MovieDTO dto where dto.movie_id="+id+"";
		MovieDTO movieDTO = new MovieDTO();
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			movieDTO = (MovieDTO) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if(session != null) {
				session.close();
			}else {
				System.out.println("session cannot be closed");
			}
		}
		return movieDTO;
	}

	@Override
	public String getMovieLanguageByMovieName(String movieName) {
		Session session = null;
		String movielanguage = null;
		String hql = "select dto.language from MovieDTO  dto where dto.movieName='"+movieName+"'";
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			movielanguage = (String) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.clear();
			}else {
				
				System.out.println("session cannot be closed");
			}
			if(HibernateUtil.getSessionFactory() != null) {
				HibernateUtil.getSessionFactory().close();
			}
		}
		return movielanguage;
	}

	@Override
	public Object[] getNameAndRatingByLanguage(String language) {
		Session session = null;
		Object[] movieNameAndRating = null;
		String hql = "select dto.movieName, dto.movieRating from MovieDTO dto where dto.language='"+language+"'";
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			movieNameAndRating = (Object[]) query.uniqueResult();
			return movieNameAndRating;
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
