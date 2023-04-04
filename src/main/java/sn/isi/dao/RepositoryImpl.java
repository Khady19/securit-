package sn.isi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sn.isi.entities.Comptes;
import sn.isi.hibernate.HibernateUtil;

public class RepositoryImpl <T> implements Repository<T>{
	
	protected Session session;
	protected Transaction transaction;
	
	public RepositoryImpl () {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	

	@Override
	public int add(T t) {
		int result=1;
		transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		
		return result;
	}

	@Override
	public int delete(int id, T t) {
		int result=1;
		
		transaction = session.beginTransaction();
		session.delete(session.get(t.getClass(), id));
		transaction.commit();
		return result;
	}

	@Override
	public int update(T t) {
		int result=1;
		transaction = session.beginTransaction();
		session.merge(t);
		transaction.commit();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(T t) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	       return (List<T>) session.createCriteria(t.getClass()).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int id, T t) {
		return (T) session.get(t.getClass(), id);

	}
	
	public List<Comptes> selectAll() {
        Transaction transaction = null;
        List<Comptes> listcomptes = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            listcomptes = session.createQuery("from comptes").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listcomptes;
    }
	
	 public boolean validate(String username, String password) {
		 
	        Transaction transaction = null;
	        Comptes comptes = null;
	        try  {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            comptes = (Comptes) session.createQuery("FROM Comptes C WHERE C.username = :username").setParameter("username", username)
	                    .uniqueResult();

	            if (comptes != null && comptes.getPassword().equals(password)) {
	                return true;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return false;
	    }
	

}
