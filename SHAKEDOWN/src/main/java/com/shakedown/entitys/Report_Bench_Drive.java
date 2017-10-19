package com.shakedown.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Entity
@Table(name = "T_REPORTE_BENCH_DRIVE_TEST", schema = "dbo" , catalog = "SHAKEDOWN")
@NoArgsConstructor
@AllArgsConstructor
public class Report_Bench_Drive {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reporte", unique = true, nullable = false)
	private @Getter @Setter Integer id;
	@Column(name = "nombre")
	private @Getter @Setter String nombre;
	@Column(name = "semana")
	private @Getter @Setter String semana;
	@Column(name = "tipo")
	private @Getter @Setter String tipo;
	@Column(name = "fecha")
	private @Getter @Setter Date fecha;
	@Column(name = "status")
	private @Getter @Setter String status;
	
	@ManyToOne
	@JoinColumn(name = "idFileEvento")
	private @Getter @Setter RutaGoogle idFileEvento;
	
	@OneToOne(mappedBy = "idReporte")
	private @Getter @Setter Eventos idEventos;
	
	@Override
	public String toString() {
		return "Report_Bench_Drive [id=" + id + ", nombre=" + nombre + ", semana=" + semana + ", tipo=" + tipo
				+ ", fecha=" + fecha + ", status=" + status + "]";
	}
	
	
	

}