package com.shakedown.service.api;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, D, PK extends Serializable> {

	/**
	 * Creates a record
	 * @param D entity
	 * @return the Entity saved instance
	 * @throws ServiceException
	 */
	public PK create(D D) throws ServiceException;

	/**
	 * Finds a record based on its Id
	 * @param id the id of the record
	 * @return the instance
	 * @throws ServiceException
	 */
	public D find(PK id) throws ServiceException;

	/**
	 * Updates the record instance
	 * @param D the instance
	 * @return the instance updated
	 * @throws ServiceException
	 */
	public void update(D D) throws ServiceException;


	/**
	 * Finds all elements 
	 * @return the list
	 * @throws ServiceException
	 */
	List<D> findAll() throws ServiceException;

	/**
	 * Deletes an instance
	 * @param entity the instance
	 * @throws ServiceException
	 */
	void delete(D entity) throws ServiceException;

	void saveList(List<D> list) throws ServiceException;

	
}
