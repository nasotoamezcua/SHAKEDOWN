package com.nasoto.intercambios.forms;

import java.util.List;

import com.nasoto.intercambios.entities.Intercambios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {
	
	private Long idUsuario;
	private Long idCustomer;
	private String user;
	private String mail;
	private String password;
	private String confirPassword;
	private String nombre;
	private String genero;
	private String flagSaveUpdate;
	private List<Intercambios> intercambios;

}
