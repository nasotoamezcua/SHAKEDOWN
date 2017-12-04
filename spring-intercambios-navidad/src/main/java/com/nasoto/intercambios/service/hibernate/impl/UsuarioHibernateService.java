package com.nasoto.intercambios.service.hibernate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.dao.api.IUsuarioDAO;
import com.nasoto.intercambios.entities.Usuario;
import com.nasoto.intercambios.service.api.IUsuarioService;
import com.nasoto.intercambios.service.hibernate.GenericHibernateService;

@Repository("usuarioHibernateService")
public class UsuarioHibernateService 
	extends GenericHibernateService<Usuario, Long> implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO dao;

	@Override
	protected IGenericDAO<Usuario, Long> getDAO() {
		return dao;
	}

	@Override
	public Usuario findByUserNameService(String nom_usua) {
		Usuario usuario = dao.findByUserName(nom_usua);
		return usuario;
	}
}
