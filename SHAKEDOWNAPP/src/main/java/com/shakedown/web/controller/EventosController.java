package com.shakedown.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shakedown.dto.ReporteDTO;
import com.shakedown.service.api.ReporteService;
import com.shakedown.service.api.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("eventosController")
public class EventosController {
	
	@Autowired
	private ReporteService reportService;
	
    @RequestMapping(method = RequestMethod.GET, value = "/")
	public String requestIndex(Map<String, Object> model) {
    	log.info("requestIndex");
    	
    	List<ReporteDTO> lisReports = null;
    	List<ArrayList<ReporteDTO>> listaReportesDTO = new ArrayList<ArrayList<ReporteDTO>>();
    	
    	for(int i=1;i<=3;i++) {
			try {
				lisReports = reportService.listReportsServiceIdZona(i);
				listaReportesDTO.add((ArrayList<ReporteDTO>) lisReports);
			}catch (ServiceException e) {
				log.error(e.getMessage(), e);
			}
		}
    	
    	model.put("listaReportesDTO", listaReportesDTO);
    	
		return "index";
	}
}
