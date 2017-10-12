package com.shakedown.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("loginController")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/myLogin")
	public String login(Map<String, Object> model) {
		log.info("Metodo: login()");
		return "login/login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/login-error")
	public ModelAndView loginError() {
		log.info("Metodo: loginError()");
		
		ModelAndView model = new ModelAndView();
		model.addObject("valFalse", true);
		model.setViewName("login/login");
		
		return model;
		
	}
	
	

}
