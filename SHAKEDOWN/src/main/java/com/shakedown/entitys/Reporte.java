package com.shakedown.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "T_REPORTE_EVENTO", schema = "dbo", catalog = "SHAKEDOWN")
@ToString
public class Reporte {
	
	private Integer id;
	private String nombre;
	private String file_evento_js;
	private Date fehca;
	private Zonas zona;
	private String status;
	
	@Id
	@Column(name = "id_reporte", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "file_evento_js")
	public String getFile_evento_js() {
		return file_evento_js;
	}
	public void setFile_evento_js(String file_evento_js) {
		this.file_evento_js = file_evento_js;
	}
	
	@Column(name = "fecha")
	public Date getFehca() {
		return fehca;
	}
	public void setFehca(Date fehca) {
		this.fehca = fehca;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_zona")
	public Zonas getZona() {
		return zona;
	}
	public void setZona(Zonas zona) {
		this.zona = zona;
	}
	
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
