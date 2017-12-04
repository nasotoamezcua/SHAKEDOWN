package com.nasoto.intercambios.dao.api;

import java.util.List;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.entities.Intercambios;

public interface IIntercambiosDAO extends IGenericDAO<Intercambios, Long>{
	
	List<Intercambios> finByIntercambiosIDCustomer(Long idCustomer);

}
