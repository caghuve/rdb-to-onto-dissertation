package br.ufpr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufpr.bean.Hierarchy;
import br.ufpr.bean.Table;

public class HierarchyDao extends GenericDao {

	@SuppressWarnings("unchecked")
	public List<Hierarchy> listAll() {
		Session session = getSession();
		Transaction tx = null;
		List<Hierarchy> retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Hierarchy.class);
			retorno = criteria.list();
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			session.close(); 
		}

		return retorno;
	}
	
	/**
	 * 
	 * @param classId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Hierarchy> listSubClasses(Long classId) {		
		Session session = getSession();
		Transaction tx = null;
		List<Hierarchy> retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Hierarchy.class);
			criteria.add(Restrictions.eq("superClass.id", classId));
			//criteria.add(Restrictions.eq("subClass.id", classId));
			retorno =  criteria.list();
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace(); 
		}catch (Exception e) {
			retorno = null;
		}
		finally {
			session.close(); 
		}
		return retorno;
	}
	
	/**
	 * 
	 * @param classId
	 * @return
	 */
	public Hierarchy getSubClass(Long superClass, Long subClass) {		
		Session session = getSession();
		Transaction tx = null;
		Hierarchy retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Hierarchy.class);
			criteria.add(Restrictions.eq("superClass.id", superClass));
			criteria.add(Restrictions.eq("subClass.id", subClass));
			retorno = (Hierarchy) criteria.list().get(0);
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace(); 
		}catch (Exception e) {
			retorno = null;
		}
		finally {
			session.close(); 
		}
		return retorno;
	}
}