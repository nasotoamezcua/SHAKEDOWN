package com.nasoto.intercambios.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.api.IRolesDAO;
import com.nasoto.intercambios.dao.hibernate.GenericHibernateDAO;
import com.nasoto.intercambios.entities.Roles;

@Repository("rolesHibernateDAO")
public class RolesHibernateDAO
	extends GenericHibernateDAO<Roles, Long> implements IRolesDAO{

	public RolesHibernateDAO() {
		super(Roles.class);
	}

}
