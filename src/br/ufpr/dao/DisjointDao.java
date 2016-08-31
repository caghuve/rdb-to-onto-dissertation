package br.ufpr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import br.ufpr.bean.Disjoint;
import br.ufpr.bean.Hierarchy;

public class DisjointDao extends GenericDao {
	/**
	 * 
	 * @param classId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Disjoint> listDisjointClasses(Long classId) {		
		Session session = getSession();
		Transaction tx = null;
		List<Disjoint> retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Disjoint.class);
			criteria.add(Restrictions.eq("classD.id", classId));
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
	public Disjoint getDisjointClass(Long classD, Long disjointClass) {		
		Session session = getSession();
		Transaction tx = null;
		Disjoint retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Disjoint.class);
			criteria.add(Restrictions.eq("classD.id", classD));
			criteria.add(Restrictions.eq("disjointClass.id", disjointClass));
			retorno = (Disjoint) criteria.list().get(0);
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