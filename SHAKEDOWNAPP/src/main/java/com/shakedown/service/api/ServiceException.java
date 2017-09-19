package com.shakedown.service.api;

import com.shakedown.persistence.api.PersistenceException;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, PersistenceException e) {
		super(message, e);
		// TODO Auto-generated constructor stub
	}	
}
