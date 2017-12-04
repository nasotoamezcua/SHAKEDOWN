package com.nasoto.intercambios.dao.hibernate.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.api.ICustomerDAO;
import com.nasoto.intercambios.dao.hibernate.GenericHibernateDAO;
import com.nasoto.intercambios.entities.Customer;

@Repository("customerHibernateDAO")
public class CustomerHibernateDAO
	extends GenericHibernateDAO<Customer, Long> implements ICustomerDAO{

	public CustomerHibernateDAO() {
		super(Customer.class);
	}

	@Override
	public Customer findByCustomerEmail(String mail) {
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(Customer.class)
				.add(Restrictions.eq("mail", mail));
		
		Customer customer = (Customer)c.uniqueResult();
		
		return customer;
	}

}
