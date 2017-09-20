package com.shakedown.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.shakedown.dto.ReporteDTO;
import com.shakedown.service.api.ReporteService;
import com.shakedown.service.api.ServiceException;

import lombok.extern.slf4j.Slf4j;

/*	
 * @Namespace solo se declara a nivel de clase.
*/
@Slf4j
@Component("eventosActionBean")
@Namespace(value = "/eventos")
@Action(value = "eventosAction", 
	results = {@Result(name = "success", location = "/WEB-INF/views/jsp/index.jsp")
	})
public class EventosAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private ReporteService reportService;
	
	private List<ArrayList<ReporteDTO>> listaReportesDTO;
	
	@Override
	/* 	 
	 * A nivel de Metodo se agrega el Namespace seguido del nombre del Action
	 * 	 
	@Action(value = "/eventos/eventosAction", 
		results = {@Result(name = "success", location = "/WEB-INF/views/jsp/index.jsp")
		})
	*/
	public String execute() { 
		
		listaReportesDTO = new ArrayList<ArrayList<ReporteDTO>>();
		
		for(int i=1;i<=3;i++) {
			try {
					List<ReporteDTO> lisReports = reportService.listReportsServiceIdZona(i);
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
