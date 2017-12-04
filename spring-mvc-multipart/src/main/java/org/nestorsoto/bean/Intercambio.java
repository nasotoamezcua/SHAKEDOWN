package org.nestorsoto.bean;

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
public class Intercambio {
	
	private String name;
	private String status;
	private MultipartFile file;
	private String nameFile;
	private String pathFile;
	
	public Intercambio(String name, String status, String nameFile, String pathFile) {
		super();
		this.name = name;
		this.status = status;
		this.nameFile = nameFile;
		this.pathFile = pathFile;
	}
}
