package br.ufpr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufpr.bean.Column;
import br.ufpr.bean.ColumnCheckValue;
import br.ufpr.bean.ColumnRecordValue;
import br.ufpr.bean.Instance;
import br.ufpr.bean.Record;

public class ColumnRecordValueDao extends GenericDao {

	public ColumnRecordValue getByColumn(Column column, String recordValue) {
		if (column == null) {
			return null;
		}
		
		Session session = getSession();
		Transaction tx = null;
		ColumnRecordValue retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(ColumnRecordValue.class);
			criteria.add(Restrictions.eq("column", column));
			criteria.add(Restrictions.eq("recordValue", recordValue));
			
			try {
				retorno = (ColumnRecordValue) criteria.list().get(0);
			}
			catch (Exception e) {
				retorno = null;
			}
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
	
	@SuppressWarnings("unchecked")
	public List<ColumnRecordValue> listAllByRecord(Record record) {
		Session session = getSession();
		Transaction tx = null;
		List<ColumnRecordValue> retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(ColumnRecordValue.class);
			criteria.add(Restrictions.eq("record", record));
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
	
	@SuppressWarnings("unchecked")
	public List<ColumnRecordValue> listAllByColumn(Column column) {
		Session session = getSession();
		Transaction tx = null;
		List<ColumnRecordValue> retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(ColumnRecordValue.class);
			criteria.add(Restrictions.eq("column", column));
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
}