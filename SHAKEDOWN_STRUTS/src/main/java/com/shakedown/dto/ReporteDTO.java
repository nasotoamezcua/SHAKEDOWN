package com.shakedown.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReporteDTO {
	
	private Integer id;
	private String nombre;
	private String file_evento_js;
	private Date fecha;
	private ZonasDTO zona;
	private String status;
}
