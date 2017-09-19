package com.shakedown.service.api;

import java.util.List;

import com.shakedown.dto.ReporteDTO;
import com.shakedown.entitys.Reporte;

public interface ReporteService extends GenericService<Reporte, ReporteDTO, Integer> {
	
	List<ReporteDTO> listReportsServiceIdZona(Integer idZona) throws ServiceException;
	
	ReporteDTO findReportServiceId(Integer idReporr) throws ServiceException;

}
