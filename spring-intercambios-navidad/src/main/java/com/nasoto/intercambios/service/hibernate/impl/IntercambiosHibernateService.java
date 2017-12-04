package com.nasoto.intercambios.service.hibernate.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.dao.api.IIntercambiosDAO;
import com.nasoto.intercambios.entities.Intercambios;
import com.nasoto.intercambios.service.api.IIntercambiosService;
import com.nasoto.intercambios.service.hibernate.GenericHibernateService;

@Repository("intercambiosHibernateService")
public class IntercambiosHibernateService 
	extends GenericHibernateService<Intercambios, Long> implements IIntercambiosService{

	@Autowired
	private IIntercambiosDAO dao;
	
	@Override
	protected IGenericDAO<Intercambios, Long> getDAO() {
		return dao;
	}

	@Override
	public List<Intercambios> finByIntercambiosIDCustomerService(Long idCustomer) {
		return dao.finByIntercambiosIDCustomer(idCustomer);
	}

}
