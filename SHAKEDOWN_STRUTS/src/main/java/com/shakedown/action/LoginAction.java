package com.shakedown.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private boolean validacion;
	
	@Action(value = "/login/loginAction", results = {
			@Result(name = SUCCESS , location = "/WEB-INF/views/jsp/login/login.jsp")
	})
	@Override
	public String execute() {
		log.info("Spring Security Login");
		
		return SUCCESS;
	}
	
	@Action(value = "/login/loginErrorAction", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/jsp/login/login.jsp")
	})
	public String loginErrorAction() {
		log.info("loginErrorAction");
		this.validacion = true;
		
		return SUCCESS;
	}

	public boolean isValidacion() {
		return validacion;
	}
	
	@Action(value = "/home/homeAction", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/jsp/home.jsp")
	})
	public String loginHome() {
		log.info("loginHome");
		return SUCCESS;
	}
}
