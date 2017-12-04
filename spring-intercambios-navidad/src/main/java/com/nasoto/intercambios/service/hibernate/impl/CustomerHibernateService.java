package com.nasoto.intercambios.service.hibernate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.dao.api.ICustomerDAO;
import com.nasoto.intercambios.entities.Customer;
import com.nasoto.intercambios.service.api.ICustomerService;
import com.nasoto.intercambios.service.hibernate.GenericHibernateService;

@Repository("customerHibernateService")
public class CustomerHibernateService 
	extends GenericHibernateService<Customer, Long> implements ICustomerService{

	@Autowired
	private ICustomerDAO dao;
	
	@Override
	protected IGenericDAO<Customer, Long> getDAO() {
		return dao;
	}

	@Override
	public Customer findByCustomerEmailService(String mail) {
		Customer customer = dao.findByCustomerEmail(mail);
		return customer;
	}

}
