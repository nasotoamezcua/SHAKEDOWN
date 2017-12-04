package com.nasoto.intercambios.dao.hibernate.impl;

import org.hibernate.Criteria;
//import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nasoto.intercambios.dao.api.IUsuarioDAO;
import com.nasoto.intercambios.dao.hibernate.GenericHibernateDAO;
import com.nasoto.intercambios.entities.Usuario;

@Repository("usuarioHibernateDAO")
public class UsuarioHibernateDAO 
	extends GenericHibernateDAO<Usuario, Long> implements IUsuarioDAO {

	public UsuarioHibernateDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario findByUserName(String nom_usua) {
		
		//Con HQL
		/*
		String HQL = "SELECT u FROM Usuario u WHERE nom_usua= :nom_usua";
		
		Query q = getSessionFactory().getCurrentSession().createQuery(HQL);
		q.setParameter("nom_usua", nom_usua);
		Usuario usuario = (Usuario)q.uniqueResult();
		*/
		//Con Criteria
		
		Criteria c = getSessionFactory().getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("nom_usua", nom_usua));
		
		Usuario usuario = (Usuario)c.uniqueResult();
		
		return usuario;
	}

}
