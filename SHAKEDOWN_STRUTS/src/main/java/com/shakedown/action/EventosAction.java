package com.shakedown.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.shakedown.dto.ReporteDTO;
import com.shakedown.service.api.ReporteService;
import com.shakedown.service.api.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("eventosActionBean")
public class EventosAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteService reportService;
	
	List<ArrayList<ReporteDTO>> listaReportesDTO;
	
	@Override
	public String execute() {
		
		List<ReporteDTO> lisReports = null;
		
		for(int i=1;i<=3;i++) {
			try {
				listaReportesDTO = new ArrayList<ArrayList<ReporteDTO>>();
				lisReports = reportService.listReportsServiceIdZona(i);
				listaReportesDTO.add((ArrayList<ReporteDTO>) lisReports);
			}catch (ServiceException e) {
				log.error(e.getMessage(), e);
			}
		}
		
		return SUCCESS;
	}

	public List<ArrayList<ReporteDTO>> getListaReportesDTO() {
		return listaReportesDTO;
	}
}
