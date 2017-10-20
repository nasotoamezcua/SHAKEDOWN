package com.shakedown.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shakedown.dto.ReportBenchDriveDTO;

import lombok.Getter;

public class ReportsAction extends ActionSupport implements ModelDriven<ReportBenchDriveDTO> {

	private static final long serialVersionUID = 1L;
	
	private @Getter ReportBenchDriveDTO model = new ReportBenchDriveDTO();
	
	@Override
	@Action(value = "/reports/newReportsAction", results = {
			@Result(name = "success", location = "/WEB-INF/views/jsp/report/newReport.jsp")
	})
	public String execute() {
		return SUCCESS;
	}
	
}
