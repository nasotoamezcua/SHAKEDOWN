package com.nasoto.intercambios.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginControler {
	
	@RequestMapping(value = {"","/","/login"}, method = RequestMethod.GET)
	public String showLoginPage(Model model,
				@RequestParam(required = false, value = "error") boolean error,
				@RequestParam(required = false, value = "sesion") boolean sesion) {
		
		log.info("show login page ------------------");
		
		if(error) {
			model.addAttribute("errorMessage","Nombre de usuario o password incorrectos.");
		}if(sesion) {
			model.addAttribute("errorMessage","Session Finalizada.");
		}
		
		return "login/login";
	}

}
