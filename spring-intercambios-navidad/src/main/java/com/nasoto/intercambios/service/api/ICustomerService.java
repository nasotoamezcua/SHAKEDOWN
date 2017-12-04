package com.nasoto.intercambios.service.api;

import com.nasoto.intercambios.entities.Customer;
import com.nasoto.intercambios.service.IGenericService;

public interface ICustomerService extends IGenericService<Customer, Long> {
	
	Customer findByCustomerEmailService(String mail);

}
