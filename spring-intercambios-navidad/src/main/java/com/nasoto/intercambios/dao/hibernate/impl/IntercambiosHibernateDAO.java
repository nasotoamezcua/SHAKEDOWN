package com.nasoto.intercambios.dao.hibernate.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.api.IIntercambiosDAO;
import com.nasoto.intercambios.dao.hibernate.GenericHibernateDAO;
import com.nasoto.intercambios.entities.Intercambios;

@Repository("intercambiosHibernateDAO")
public class IntercambiosHibernateDAO
	extends GenericHibernateDAO<Intercambios, Long> implements IIntercambiosDAO{

	public IntercambiosHibernateDAO() {
		super(Intercambios.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Intercambios> finByIntercambiosIDCustomer(Long idCustomer) {
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(Intercambios.class)
				.add(Restrictions.eq("customer.id", idCustomer))
				.add(Restrictions.eq("anio", Calendar.getInstance().get(Calendar.YEAR)));
		
		List<Intercambios> listIntercambios = c.list();
		
		return listIntercambios;
	}

}
