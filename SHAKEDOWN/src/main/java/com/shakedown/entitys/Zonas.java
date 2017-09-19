package com.shakedown.entitys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_ZONAS", schema = "dbo", catalog = "SHAKEDOWN")
public class Zonas {
	
	private Integer id;
	private String nombre;
	private String file_layer;
	private Double zoom;
	private Double lat;
	private Double lng;
	private Set<Reporte> reportes = new HashSet<Reporte>();
	
	@Id
	@Column(name = "ID_ZONA", unique = true, nullable = false) 
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
	
	@Column(name = "file_layer")
	public String getFile_layer() {
		return file_layer;
	}
	public void setFile_layer(String file_layer) {
		this.file_layer = file_layer;
	}
	
	@Column(name = "zoom")
	public Double getZoom() {
		return zoom;
	}
	public void setZoom(Double zoom) {
		this.zoom = zoom;
	}
	
	@Column(name = "lat")
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	@Column(name = "lng")
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "zona")
	public Set<Reporte> getReportes() {
		return reportes;
	}
	public void setReportes(Set<Reporte> reportes) {
		this.reportes = reportes;
	}
}
