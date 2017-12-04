package com.nasoto.intercambios.service.hibernate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.dao.api.IRolesDAO;
import com.nasoto.intercambios.entities.Roles;
import com.nasoto.intercambios.service.api.IRolesService;
import com.nasoto.intercambios.service.hibernate.GenericHibernateService;

@Repository("rolesHibernateService")
public class RolesHibernateService
	extends GenericHibernateService<Roles, Long> implements IRolesService{

	@Autowired
	private IRolesDAO dao;
	
	@Override
	protected IGenericDAO<Roles, Long> getDAO() {
		return dao;
	}

}
