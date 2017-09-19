package com.shakedown.service.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakedown.dto.ReporteDTO;
import com.shakedown.entitys.Reporte;
import com.shakedown.persistence.api.GenericDAO;
import com.shakedown.persistence.api.PersistenceException;
import com.shakedown.persistence.api.ReporteDAO;
import com.shakedown.service.api.ReporteService;
import com.shakedown.service.api.ServiceException;
import com.shakedown.service.assembler.Assembler;
import com.shakedown.service.assembler.ReporteAssembler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("reporteService")
public class ReporteServiceImpl extends GenericServiceImpl<Reporte, ReporteDTO, Integer> 
	implements ReporteService {
	
	@Autowired
	private ReporteDAO dao;
	
	@Autowired
	private ReporteAssembler assembler;
	
	@Override
	protected GenericDAO<Reporte, Integer> getDAO() {
		// TODO Auto-generated method stub
		return dao;
	}

	@Override
	protected Assembler<ReporteDTO, Reporte> getAssembler() {
		// TODO Auto-generated method stub
		return assembler;
	}

	@Override
	public List<ReporteDTO> listReportsServiceIdZona(Integer idZona) throws ServiceException{
		
		List<ReporteDTO> listReporte_DTO = null; 
		
		try {
			List<Reporte> entity_ = dao.listReportsIdZona(idZona);
			listReporte_DTO = assembler.getDTOListTransform(entity_);
			
		}catch (PersistenceException e) {
			log.error(e.getMessage(), e);
		}
		
		return listReporte_DTO;
	}

	@Override
	public ReporteDTO findReportServiceId(Integer idReporr) throws ServiceException {
		
		ReporteDTO reporte_DTO = null;
		
		try {
			Reporte entity_ = dao.findReportId(idReporr);
			reporte_DTO = assembler.getDTOTransform(entity_);
		}catch (PersistenceException e) {
			log.error(e.getMessage(), e);
		}
		
		return reporte_DTO;
	}	

}
