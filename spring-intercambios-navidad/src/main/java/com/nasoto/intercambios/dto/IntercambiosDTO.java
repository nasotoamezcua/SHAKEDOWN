package com.nasoto.intercambios.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntercambiosDTO {
	
	private Long idIntercambio;
	private Long idCustomer;
	private String opcion;
	private MultipartFile file;
	private String nameFile;
	private String pathFile;
	private String glyphicon;

}
