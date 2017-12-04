package com.nasoto.intercambios.dao.api;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.entities.Customer;

public interface ICustomerDAO extends IGenericDAO<Customer, Long>{
	
	Customer findByCustomerEmail(String mail);

}
