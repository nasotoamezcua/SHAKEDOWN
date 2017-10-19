package com.shakedown.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("eventosController")
public class EventosController {
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(Map<String, Object> model) {
		log.info("home");
		return "home";
	}
	
    
}
