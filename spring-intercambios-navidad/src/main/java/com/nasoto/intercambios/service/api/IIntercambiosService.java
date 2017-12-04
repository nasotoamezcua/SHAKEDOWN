package com.nasoto.intercambios.service.api;

import java.util.List;

import com.nasoto.intercambios.entities.Intercambios;
import com.nasoto.intercambios.service.IGenericService;

public interface IIntercambiosService extends IGenericService<Intercambios, Long> {
	
	List<Intercambios> finByIntercambiosIDCustomerService(Long idCustomer);

}
