package com.shakedown.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/reports")
@Action(value = "newReportsAction", results = {
		@Result(name = "success", location = "/WEB-INF/views/jsp/report/newReport.jsp")
})
public class ReportsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() {
		return SUCCESS;
	}

}
