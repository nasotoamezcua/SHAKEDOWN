package com.nasoto.intercambios.service.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.dao.hibernate.api.IHibernateExtraOperationsDAO;
import com.nasoto.intercambios.service.IGenericService;


@Transactional
public abstract class GenericHibernateService<T, ID extends Serializable> 
	implements IGenericService<T, ID> {
	
	protected abstract IGenericDAO<T, ID> getDAO();
	
	@Override
	public void insert(T entity) {
		getDAO().insert(entity);
	}
	
	@Override
	public void update(T entity){
		getDAO().update(entity);
	}
	
	@Override
	public T findById(ID id){
		return getDAO().findById(id);
	}
	
	@Override
	public T delete(ID id) {
		final T entity = this.findById(id);
		return this.delete(entity);
	}

	@Override
	public T delete(T entity) {
		if (entity != null) {
			getDAO().delete(entity);
		}
		return entity;
	}
	
	@Override
	public List<T> findAll(){
		return getDAO().findAll();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void detach(T entity) {
		((IHibernateExtraOperationsDAO<T, ID>)getDAO()).detach(entity);
	}
}
