package com.nasoto.intercambios.dao.api;

import com.nasoto.intercambios.dao.IGenericDAO;
import com.nasoto.intercambios.entities.Usuario;

public interface IUsuarioDAO extends IGenericDAO<Usuario, Long>{
	
	Usuario findByUserName(String name);

}
