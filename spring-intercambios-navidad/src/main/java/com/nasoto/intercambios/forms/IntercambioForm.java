package com.nasoto.intercambios.forms;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"file"})
@EqualsAndHashCode(exclude = {"file"})
public class IntercambioForm {
	
	private Long idIntercambio;
	private Long idCustomer;
	private String opcion;
	private MultipartFile file;
	private String nameFile;
	private String pathFile;
	private String glyphicon;
	
	public IntercambioForm(String opcion, String nameFile, String pathFile, String glyphicon) {
		super();
		this.opcion = opcion;
		this.nameFile = nameFile;
		this.pathFile = pathFile;
		this.glyphicon = glyphicon;
	}

}
