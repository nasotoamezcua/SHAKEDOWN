package com.nasoto.intercambios.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
	
	private Long idUsuario;
	private Long idCustomer;
	private String user;
	private String mail;
	private String password;
	private String confirPassword;
	private String nombre;
	private String genero;
	private String flagSaveUpdate;
	
	private List<IntercambiosDTO> intercambiosDTO;
	
	

}
