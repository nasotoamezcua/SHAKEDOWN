package com.shakedown.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ZonasDTO {
	
	private Integer id;
	private String nombre;
	private String file_layer;
	private Double zoom;
	private Double lat;
	private Double lng;

}
