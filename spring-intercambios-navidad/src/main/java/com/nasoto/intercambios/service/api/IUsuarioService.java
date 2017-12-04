package com.nasoto.intercambios.service.api;

import com.nasoto.intercambios.entities.Usuario;
import com.nasoto.intercambios.service.IGenericService;

public interface IUsuarioService extends IGenericService<Usuario, Long> {
	
	Usuario findByUserNameService(String nom_usua);

}
