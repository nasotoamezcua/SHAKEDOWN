package com.shakedown.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.shakedown.dto.ReportBenchDriveDTO;
import com.shakedown.service.api.ReportBenchDriveService;
import com.shakedown.service.api.ServiceException;

import lombok.extern.slf4j.Slf4j;

/*	
 * @Namespace solo se declara a nivel de clase.
*/
@Slf4j
//@Component("eventosActionBean")
@Namespace(value = "/eventos")
@Action(value = "eventosAction", 
	results = {@Result(name = "success", location = "/WEB-INF/views/jsp/index.jsp")
	})
public class EventosAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReportBenchDriveService reportService;
	
	private List<ArrayList<ReportBenchDriveDTO>> listaReportesDTO;
	
	
	
	@Override
	/* 	 
	 * A nivel de Metodo se agrega el Namespace seguido del nombre del Action
	 * 	 
	@Action(value = "/eventos/eventosAction", 
		results = {@Result(name = "success", location = "/WEB-INF/views/jsp/index.jsp")
		})
	*/
	public String execute() {
		
		log.info("Action: eventosAction");
		
		listaReportesDTO = new ArrayList<ArrayList<ReportBenchDriveDTO>>();
		
		for(int i=1;i<=2;i++) {
			String valor = (i==1)?"BM":"DT";
			try {
					List<ReportBenchDriveDTO> lisReports = reportService.lisReportBenchDriveFindAllService(valor);
					listaReportesDTO.add((ArrayList<ReportBenchDriveDTO>) lisReports);
			}catch (ServiceException e) {
				log.error(e.getMessage(), e);
			}
		}
		
		return SUCCESS;
	}

	public List<ArrayList<ReportBenchDriveDTO>> getListaReportesDTO() {
		return listaReportesDTO;
	}
	
}
