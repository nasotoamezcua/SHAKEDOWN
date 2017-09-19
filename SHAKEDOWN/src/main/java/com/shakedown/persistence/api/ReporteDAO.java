package com.shakedown.persistence.api;

import java.util.List;

import com.shakedown.entitys.Reporte;



public interface ReporteDAO 
	extends GenericDAO<Reporte, Integer> {
	
	
	List<Reporte> listReportsIdZona(Integer idZona) throws PersistenceException;
	
	Reporte findReportId(Integer idReporr) throws PersistenceException;

}
