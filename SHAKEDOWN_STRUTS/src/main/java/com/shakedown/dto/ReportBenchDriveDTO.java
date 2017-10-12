package com.shakedown.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class ReportBenchDriveDTO {
	
	private @Getter @Setter Integer id;
	private @Getter @Setter String nombre;
	private @Getter @Setter Integer complete;
	private @Getter @Setter Integer fails;
	private @Getter @Setter Integer drops;
	private @Getter @Setter String semana;
	private @Getter @Setter Date fecha;

}
